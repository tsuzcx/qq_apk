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
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.e.e;
import com.tencent.mm.plugin.emoji.f.m;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.plugin.emoji.ui.SquareImageView;
import com.tencent.mm.protocal.protobuf.EmotionDonor;
import com.tencent.mm.protocal.protobuf.GetEmotionRewardResponse;
import com.tencent.mm.protocal.protobuf.bap;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.emotion.o;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMLoadScrollView.a;
import com.tencent.mm.ui.z;
import java.io.IOException;
import java.util.LinkedList;

public class EmojiStoreV2RewardDetailUI
  extends MMActivity
  implements AbsListView.OnScrollListener, f
{
  private View agn;
  private ap gKD;
  private boolean isLoading;
  private ListView mListView;
  private String pFH;
  private String pFt;
  private int pHg;
  private GetEmotionRewardResponse pJQ;
  private String pNl;
  private String pNm;
  private ImageView pNn;
  private TextView pNo;
  private TextView pNp;
  private TextView pNq;
  private View pNr;
  private View pNs;
  private a pNt;
  private bap pNu;
  private byte[] pNv;
  private m pNw;
  private MMLoadScrollView.a pNx;
  
  public EmojiStoreV2RewardDetailUI()
  {
    AppMethodBeat.i(109253);
    this.isLoading = false;
    this.pHg = -1;
    this.gKD = new ap()
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
    this.pNx = new MMLoadScrollView.a()
    {
      public final void ciN()
      {
        AppMethodBeat.i(109245);
        ad.i("MicroMsg.emoji.EmojiStoreV2RewardDetailUI", "onBottom");
        EmojiStoreV2RewardDetailUI.b(EmojiStoreV2RewardDetailUI.this);
        AppMethodBeat.o(109245);
      }
    };
    AppMethodBeat.o(109253);
  }
  
  private void ciM()
  {
    AppMethodBeat.i(109258);
    this.pNw = new m(this.pFt, this.pNv);
    g.ajB().gAO.a(this.pNw, 0);
    AppMethodBeat.o(109258);
  }
  
  private void kz(boolean paramBoolean)
  {
    AppMethodBeat.i(109259);
    if ((!this.isLoading) && (this.pHg != 0))
    {
      ciM();
      this.isLoading = true;
      if (paramBoolean) {
        this.gKD.sendEmptyMessageDelayed(1002, 200L);
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
    this.agn = z.jO(getContext()).inflate(2131493818, null);
    this.pNn = ((ImageView)this.agn.findViewById(2131299022));
    this.pNo = ((TextView)this.agn.findViewById(2131303438));
    this.pNp = ((TextView)this.agn.findViewById(2131299023));
    this.pNq = ((TextView)this.agn.findViewById(2131304156));
    this.pNr = findViewById(2131304239);
    this.mListView = ((ListView)findViewById(2131300717));
    this.pNs = z.jO(getContext()).inflate(2131493799, null);
    this.pNs.setVisibility(8);
    this.mListView.addHeaderView(this.agn);
    this.mListView.addFooterView(this.pNs);
    this.pNt = new a(this);
    this.mListView.setAdapter(this.pNt);
    this.mListView.setOnScrollListener(this);
    AppMethodBeat.o(109257);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(109254);
    super.onCreate(paramBundle);
    this.pFt = getIntent().getStringExtra("extra_id");
    this.pFH = getIntent().getStringExtra("extra_name");
    this.pNl = getIntent().getStringExtra("extra_iconurl");
    this.pNm = getIntent().getStringExtra("name");
    initView();
    this.pJQ = k.getEmojiStorageMgr().ILs.aUU(this.pFt);
    ciM();
    com.tencent.mm.aw.q.aIJ().a(this.pNl, this.pNn, e.fu(this.pFt, this.pNl));
    this.pNo.setText(this.pFH);
    this.pNp.setText(this.pNm);
    if (this.pNu != null)
    {
      this.pNt.Y(this.pNu.Donors);
      this.pNt.pNA = true;
    }
    if (this.pJQ != null) {
      this.pNq.setText(getString(2131758356, new Object[] { Integer.valueOf(this.pJQ.DonorNum) }));
    }
    g.ajB().gAO.a(299, this);
    AppMethodBeat.o(109254);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(109256);
    super.onDestroy();
    g.ajB().gAO.b(299, this);
    com.tencent.mm.aw.q.aIJ().cp(0);
    AppMethodBeat.o(109256);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(109255);
    super.onPause();
    AppMethodBeat.o(109255);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    int i = 1;
    AppMethodBeat.i(109260);
    this.isLoading = false;
    if (this.pNs != null)
    {
      this.pNs.setVisibility(8);
      this.gKD.removeMessages(1002);
      this.gKD.sendEmptyMessageDelayed(1001, 200L);
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
        this.pNv = paramString.pGa;
        if (paramInt2 == 0)
        {
          this.pHg = 0;
          if (paramString.chi() != null)
          {
            this.pNt.Y(paramString.chi().Donors);
            AppMethodBeat.o(109260);
          }
        }
        else if (paramInt2 == 2)
        {
          this.pHg = 2;
          if (paramString.chi() != null) {
            this.pNt.Y(paramString.chi().Donors);
          }
          paramInt1 = i;
          if (this.pNt != null)
          {
            paramInt1 = i;
            if (this.agn != null)
            {
              paramString = this.pNt;
              paramInt1 = paramString.pMd;
              paramInt2 = paramString.mWv + paramInt1;
              int j = this.agn.getHeight();
              int k = com.tencent.mm.cc.a.iq(this);
              ad.i("MicroMsg.emoji.EmojiStoreV2RewardDetailUI", "item:%d header:%d window:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(j), Integer.valueOf(k) });
              paramInt1 = i;
              if (k > paramInt2 * this.pNt.getCount() + j) {
                paramInt1 = 0;
              }
            }
          }
          if (paramInt1 == 0)
          {
            kz(false);
            AppMethodBeat.o(109260);
          }
        }
        else if (paramInt2 == 3)
        {
          this.pHg = 1;
          this.pNv = null;
          this.pNt.pNA = true;
          kz(false);
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
      if ((this.pHg == 0) || (this.isLoading))
      {
        ad.d("MicroMsg.emoji.EmojiStoreV2RewardDetailUI", "No More List.");
        AppMethodBeat.o(109261);
        return;
      }
      kz(true);
      ad.i("MicroMsg.emoji.EmojiStoreV2RewardDetailUI", "[onScrollStateChanged] loadMoreData.");
      com.tencent.mm.aw.q.aIJ().cp(paramInt);
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
    private Bitmap cTq;
    private Context mContext;
    private int mNumColumns;
    int mWv;
    private int pBq;
    int pMd;
    boolean pNA;
    private LinkedList<EmotionDonor> pNz;
    
    public a(Context paramContext)
    {
      AppMethodBeat.i(109247);
      this.pNA = false;
      this.mNumColumns = 1;
      this.cTq = null;
      this.mContext = paramContext;
      this.pMd = com.tencent.mm.cc.a.ax(EmojiStoreV2RewardDetailUI.this.getContext(), 2131166213);
      int k = com.tencent.mm.cc.a.ip(EmojiStoreV2RewardDetailUI.this.getContext()) - com.tencent.mm.cc.a.ax(EmojiStoreV2RewardDetailUI.this.getContext(), 2131165480) * 2;
      int m = this.pMd;
      int n = com.tencent.mm.cc.a.ax(EmojiStoreV2RewardDetailUI.this.getContext(), 2131165490);
      int j = k / (m + n);
      int i = j;
      if (k - j * m - n * (j - 1) > m) {
        i = j + 1;
      }
      this.mNumColumns = i;
      this.pBq = com.tencent.mm.cc.a.ip(this.mContext);
      this.mWv = ((int)((this.pBq - this.mNumColumns * this.pMd) / (this.mNumColumns + 1.0F)));
      try
      {
        this.cTq = BackwardSupportUtil.b.b(this.mContext.getAssets().open("avatar/default_nor_avatar.png"), com.tencent.mm.cc.a.getDensity(null));
        AppMethodBeat.o(109247);
        return;
      }
      catch (IOException this$1)
      {
        ad.i("MicroMsg.emoji.EmojiStoreV2RewardDetailUI", "decode stream default avatar failed. %s", new Object[] { bt.flS() });
        AppMethodBeat.o(109247);
      }
    }
    
    private EmotionDonor Ce(int paramInt)
    {
      AppMethodBeat.i(109250);
      if (this.pNz != null) {
        if (this.pNz != null) {
          break label33;
        }
      }
      label33:
      for (int i = 0; paramInt >= i; i = this.pNz.size())
      {
        AppMethodBeat.o(109250);
        return null;
      }
      EmotionDonor localEmotionDonor = (EmotionDonor)this.pNz.get(paramInt);
      AppMethodBeat.o(109250);
      return localEmotionDonor;
    }
    
    public final void Y(LinkedList<EmotionDonor> paramLinkedList)
    {
      AppMethodBeat.i(109248);
      if (this.pNz == null) {
        this.pNz = new LinkedList();
      }
      if (this.pNA)
      {
        this.pNz.clear();
        this.pNA = false;
      }
      this.pNz.addAll(paramLinkedList);
      notifyDataSetChanged();
      AppMethodBeat.o(109248);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(109249);
      if (this.pNz == null) {}
      for (int i = 0; i > 0; i = this.pNz.size())
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
        ((LinearLayout)localObject1).setPadding(0, 0, 0, this.mWv);
        localObject2 = new EmojiStoreV2RewardDetailUI.b(EmojiStoreV2RewardDetailUI.this);
        ((EmojiStoreV2RewardDetailUI.b)localObject2).pBw = ((LinearLayout)localObject1);
        ((View)localObject1).setTag(localObject2);
        i = 0;
        for (;;)
        {
          paramViewGroup = (ViewGroup)localObject2;
          paramView = (View)localObject1;
          if (i >= this.mNumColumns) {
            break;
          }
          paramView = new LinearLayout.LayoutParams(this.pMd, this.pMd);
          paramView.leftMargin = this.mWv;
          paramViewGroup = new SquareImageView(this.mContext);
          ((EmojiStoreV2RewardDetailUI.b)localObject2).pBw.addView(paramViewGroup, i, paramView);
          i += 1;
        }
      }
      paramViewGroup = (EmojiStoreV2RewardDetailUI.b)paramView.getTag();
      int i = 0;
      if (i < this.mNumColumns)
      {
        int j = this.mNumColumns;
        localObject1 = (SquareImageView)paramViewGroup.pBw.getChildAt(i);
        localObject2 = Ce(j * paramInt + i);
        if (localObject2 != null)
        {
          ((SquareImageView)localObject1).setVisibility(0);
          if (!bt.isNullOrNil(((EmotionDonor)localObject2).HeadUrl)) {
            com.tencent.mm.aw.q.aIJ().a(((EmotionDonor)localObject2).HeadUrl, (ImageView)localObject1, e.L(EmojiStoreV2RewardDetailUI.c(EmojiStoreV2RewardDetailUI.this), ((EmotionDonor)localObject2).HeadUrl, this.pMd));
          }
        }
        for (;;)
        {
          i += 1;
          break;
          ((SquareImageView)localObject1).setImageBitmap(this.cTq);
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
    LinearLayout pBw;
    
    b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2RewardDetailUI
 * JD-Core Version:    0.7.0.1
 */