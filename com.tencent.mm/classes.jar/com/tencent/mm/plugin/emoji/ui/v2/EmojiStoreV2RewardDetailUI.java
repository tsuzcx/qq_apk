package com.tencent.mm.plugin.emoji.ui.v2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.LayoutParams;
import android.widget.AbsListView.OnScrollListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.aw.o;
import com.tencent.mm.kernel.b;
import com.tencent.mm.plugin.emoji.e.e;
import com.tencent.mm.plugin.emoji.f.m;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.plugin.emoji.ui.SquareImageView;
import com.tencent.mm.protocal.protobuf.EmotionDonor;
import com.tencent.mm.protocal.protobuf.GetEmotionRewardResponse;
import com.tencent.mm.protocal.protobuf.atn;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.aw;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMLoadScrollView.a;
import com.tencent.mm.ui.y;
import java.io.IOException;
import java.util.LinkedList;

public class EmojiStoreV2RewardDetailUI
  extends MMActivity
  implements AbsListView.OnScrollListener, com.tencent.mm.al.g
{
  private View adC;
  private boolean isLoading;
  private ListView mListView;
  private int oAe;
  private GetEmotionRewardResponse oCO;
  private ap oFl;
  private String oGl;
  private String oGm;
  private ImageView oGn;
  private TextView oGo;
  private TextView oGp;
  private TextView oGq;
  private View oGr;
  private View oGs;
  private a oGt;
  private atn oGu;
  private byte[] oGv;
  private m oGw;
  private MMLoadScrollView.a oGx;
  private String oyj;
  private String oyx;
  
  public EmojiStoreV2RewardDetailUI()
  {
    AppMethodBeat.i(109253);
    this.isLoading = false;
    this.oAe = -1;
    this.oFl = new ap()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(109244);
        switch (paramAnonymousMessage.what)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(109244);
          return;
          if (EmojiStoreV2RewardDetailUI.a(EmojiStoreV2RewardDetailUI.this) != null)
          {
            EmojiStoreV2RewardDetailUI.a(EmojiStoreV2RewardDetailUI.this).setVisibility(8);
            AppMethodBeat.o(109244);
            return;
            if (EmojiStoreV2RewardDetailUI.a(EmojiStoreV2RewardDetailUI.this) != null) {
              EmojiStoreV2RewardDetailUI.a(EmojiStoreV2RewardDetailUI.this).setVisibility(0);
            }
          }
        }
      }
    };
    this.oGx = new MMLoadScrollView.a()
    {
      public final void bWX()
      {
        AppMethodBeat.i(109245);
        ad.i("MicroMsg.emoji.EmojiStoreV2RewardDetailUI", "onBottom");
        EmojiStoreV2RewardDetailUI.b(EmojiStoreV2RewardDetailUI.this);
        AppMethodBeat.o(109245);
      }
    };
    AppMethodBeat.o(109253);
  }
  
  private void bWW()
  {
    AppMethodBeat.i(109258);
    this.oGw = new m(this.oyj, this.oGv);
    com.tencent.mm.kernel.g.afA().gcy.a(this.oGw, 0);
    AppMethodBeat.o(109258);
  }
  
  private void jL(boolean paramBoolean)
  {
    AppMethodBeat.i(109259);
    if ((!this.isLoading) && (this.oAe != 0))
    {
      bWW();
      this.isLoading = true;
      if (paramBoolean) {
        this.oFl.sendEmptyMessageDelayed(1002, 200L);
      }
    }
    AppMethodBeat.o(109259);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131493817;
  }
  
  public void initView()
  {
    AppMethodBeat.i(109257);
    setMMTitle(2131758355);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(109246);
        EmojiStoreV2RewardDetailUI.this.finish();
        AppMethodBeat.o(109246);
        return false;
      }
    });
    this.adC = y.js(getContext()).inflate(2131493818, null);
    this.oGn = ((ImageView)this.adC.findViewById(2131299022));
    this.oGo = ((TextView)this.adC.findViewById(2131303438));
    this.oGp = ((TextView)this.adC.findViewById(2131299023));
    this.oGq = ((TextView)this.adC.findViewById(2131304156));
    this.oGr = findViewById(2131304239);
    this.mListView = ((ListView)findViewById(2131300717));
    this.oGs = y.js(getContext()).inflate(2131493799, null);
    this.oGs.setVisibility(8);
    this.mListView.addHeaderView(this.adC);
    this.mListView.addFooterView(this.oGs);
    this.oGt = new a(this);
    this.mListView.setAdapter(this.oGt);
    this.mListView.setOnScrollListener(this);
    AppMethodBeat.o(109257);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(109254);
    super.onCreate(paramBundle);
    this.oyj = getIntent().getStringExtra("extra_id");
    this.oyx = getIntent().getStringExtra("extra_name");
    this.oGl = getIntent().getStringExtra("extra_iconurl");
    this.oGm = getIntent().getStringExtra("name");
    initView();
    this.oCO = k.getEmojiStorageMgr().Fzd.aJF(this.oyj);
    bWW();
    o.ayJ().a(this.oGl, this.oGn, e.eX(this.oyj, this.oGl));
    this.oGo.setText(this.oyx);
    this.oGp.setText(this.oGm);
    if (this.oGu != null)
    {
      this.oGt.X(this.oGu.Donors);
      this.oGt.oGA = true;
    }
    if (this.oCO != null) {
      this.oGq.setText(getString(2131758356, new Object[] { Integer.valueOf(this.oCO.DonorNum) }));
    }
    com.tencent.mm.kernel.g.afA().gcy.a(299, this);
    AppMethodBeat.o(109254);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(109256);
    super.onDestroy();
    com.tencent.mm.kernel.g.afA().gcy.b(299, this);
    o.ayJ().cq(0);
    AppMethodBeat.o(109256);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(109255);
    super.onPause();
    AppMethodBeat.o(109255);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
  {
    int i = 1;
    AppMethodBeat.i(109260);
    this.isLoading = false;
    if (this.oGs != null)
    {
      this.oGs.setVisibility(8);
      this.oFl.removeMessages(1002);
      this.oFl.sendEmptyMessageDelayed(1001, 200L);
    }
    switch (paramn.getType())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(109260);
      return;
      paramString = (m)paramn;
      if ((paramInt1 == 0) || (paramInt1 == 4))
      {
        this.oGv = paramString.oyQ;
        if (paramInt2 == 0)
        {
          this.oAe = 0;
          if (paramString.bVr() != null)
          {
            this.oGt.X(paramString.bVr().Donors);
            AppMethodBeat.o(109260);
          }
        }
        else if (paramInt2 == 2)
        {
          this.oAe = 2;
          if (paramString.bVr() != null) {
            this.oGt.X(paramString.bVr().Donors);
          }
          paramInt1 = i;
          if (this.oGt != null)
          {
            paramInt1 = i;
            if (this.adC != null)
            {
              paramString = this.oGt;
              paramInt1 = paramString.oFc;
              paramInt2 = paramString.lTO + paramInt1;
              int j = this.adC.getHeight();
              int k = com.tencent.mm.cd.a.hW(this);
              ad.i("MicroMsg.emoji.EmojiStoreV2RewardDetailUI", "item:%d header:%d window:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(j), Integer.valueOf(k) });
              paramInt1 = i;
              if (k > paramInt2 * this.oGt.getCount() + j) {
                paramInt1 = 0;
              }
            }
          }
          if (paramInt1 == 0)
          {
            jL(false);
            AppMethodBeat.o(109260);
          }
        }
        else if (paramInt2 == 3)
        {
          this.oAe = 1;
          this.oGv = null;
          this.oGt.oGA = true;
          jL(false);
          AppMethodBeat.o(109260);
        }
      }
      else
      {
        ad.w("MicroMsg.emoji.EmojiStoreV2RewardDetailUI", "unknow errType:%d", new Object[] { Integer.valueOf(paramInt1) });
      }
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    AppMethodBeat.i(109261);
    if ((paramInt == 0) && (paramAbsListView.getLastVisiblePosition() == paramAbsListView.getCount() - 1))
    {
      if ((this.oAe == 0) || (this.isLoading))
      {
        ad.d("MicroMsg.emoji.EmojiStoreV2RewardDetailUI", "No More List.");
        AppMethodBeat.o(109261);
        return;
      }
      jL(true);
      ad.i("MicroMsg.emoji.EmojiStoreV2RewardDetailUI", "[onScrollStateChanged] loadMoreData.");
      o.ayJ().cq(paramInt);
    }
    AppMethodBeat.o(109261);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
    extends BaseAdapter
  {
    private Bitmap cLa;
    int lTO;
    private Context mContext;
    private int mNumColumns;
    int oFc;
    boolean oGA;
    private LinkedList<EmotionDonor> oGz;
    private int ouf;
    
    public a(Context paramContext)
    {
      AppMethodBeat.i(109247);
      this.oGA = false;
      this.mNumColumns = 1;
      this.cLa = null;
      this.mContext = paramContext;
      this.oFc = com.tencent.mm.cd.a.ao(EmojiStoreV2RewardDetailUI.this.getContext(), 2131166213);
      int k = com.tencent.mm.cd.a.hV(EmojiStoreV2RewardDetailUI.this.getContext()) - com.tencent.mm.cd.a.ao(EmojiStoreV2RewardDetailUI.this.getContext(), 2131165480) * 2;
      int m = this.oFc;
      int n = com.tencent.mm.cd.a.ao(EmojiStoreV2RewardDetailUI.this.getContext(), 2131165490);
      int j = k / (m + n);
      int i = j;
      if (k - j * m - n * (j - 1) > m) {
        i = j + 1;
      }
      this.mNumColumns = i;
      this.ouf = com.tencent.mm.cd.a.hV(this.mContext);
      this.lTO = ((int)((this.ouf - this.mNumColumns * this.oFc) / (this.mNumColumns + 1.0F)));
      try
      {
        this.cLa = BackwardSupportUtil.b.b(this.mContext.getAssets().open("avatar/default_nor_avatar.png"), com.tencent.mm.cd.a.getDensity(null));
        AppMethodBeat.o(109247);
        return;
      }
      catch (IOException this$1)
      {
        ad.i("MicroMsg.emoji.EmojiStoreV2RewardDetailUI", "decode stream default avatar failed. %s", new Object[] { bt.eGN() });
        AppMethodBeat.o(109247);
      }
    }
    
    private EmotionDonor AE(int paramInt)
    {
      AppMethodBeat.i(109250);
      if (this.oGz != null) {
        if (this.oGz != null) {
          break label33;
        }
      }
      label33:
      for (int i = 0; paramInt >= i; i = this.oGz.size())
      {
        AppMethodBeat.o(109250);
        return null;
      }
      EmotionDonor localEmotionDonor = (EmotionDonor)this.oGz.get(paramInt);
      AppMethodBeat.o(109250);
      return localEmotionDonor;
    }
    
    public final void X(LinkedList<EmotionDonor> paramLinkedList)
    {
      AppMethodBeat.i(109248);
      if (this.oGz == null) {
        this.oGz = new LinkedList();
      }
      if (this.oGA)
      {
        this.oGz.clear();
        this.oGA = false;
      }
      this.oGz.addAll(paramLinkedList);
      notifyDataSetChanged();
      AppMethodBeat.o(109248);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(109249);
      if (this.oGz == null) {}
      for (int i = 0; i > 0; i = this.oGz.size())
      {
        i = (int)Math.ceil(i / this.mNumColumns);
        AppMethodBeat.o(109249);
        return i;
      }
      AppMethodBeat.o(109249);
      return i;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(109251);
      Object localObject1;
      Object localObject2;
      if ((paramView == null) || (paramView.getTag() == null))
      {
        localObject1 = new LinearLayout(this.mContext);
        paramView = new AbsListView.LayoutParams(-1, -2);
        ((LinearLayout)localObject1).setBackgroundResource(2131234429);
        ((LinearLayout)localObject1).setOrientation(0);
        ((LinearLayout)localObject1).setLayoutParams(paramView);
        ((LinearLayout)localObject1).setPadding(0, 0, 0, this.lTO);
        localObject2 = new EmojiStoreV2RewardDetailUI.b(EmojiStoreV2RewardDetailUI.this);
        ((EmojiStoreV2RewardDetailUI.b)localObject2).oul = ((LinearLayout)localObject1);
        ((View)localObject1).setTag(localObject2);
        i = 0;
        for (;;)
        {
          paramViewGroup = (ViewGroup)localObject2;
          paramView = (View)localObject1;
          if (i >= this.mNumColumns) {
            break;
          }
          paramView = new LinearLayout.LayoutParams(this.oFc, this.oFc);
          paramView.leftMargin = this.lTO;
          paramViewGroup = new SquareImageView(this.mContext);
          ((EmojiStoreV2RewardDetailUI.b)localObject2).oul.addView(paramViewGroup, i, paramView);
          i += 1;
        }
      }
      paramViewGroup = (EmojiStoreV2RewardDetailUI.b)paramView.getTag();
      int i = 0;
      if (i < this.mNumColumns)
      {
        int j = this.mNumColumns;
        localObject1 = (SquareImageView)paramViewGroup.oul.getChildAt(i);
        localObject2 = AE(j * paramInt + i);
        if (localObject2 != null)
        {
          ((SquareImageView)localObject1).setVisibility(0);
          if (!bt.isNullOrNil(((EmotionDonor)localObject2).HeadUrl)) {
            o.ayJ().a(((EmotionDonor)localObject2).HeadUrl, (ImageView)localObject1, e.J(EmojiStoreV2RewardDetailUI.c(EmojiStoreV2RewardDetailUI.this), ((EmotionDonor)localObject2).HeadUrl, this.oFc));
          }
        }
        for (;;)
        {
          i += 1;
          break;
          ((SquareImageView)localObject1).setImageBitmap(this.cLa);
          continue;
          ((SquareImageView)localObject1).setVisibility(8);
        }
      }
      AppMethodBeat.o(109251);
      return paramView;
    }
  }
  
  final class b
  {
    LinearLayout oul;
    
    b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2RewardDetailUI
 * JD-Core Version:    0.7.0.1
 */