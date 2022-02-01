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
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.e.e;
import com.tencent.mm.plugin.emoji.f.n;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.plugin.emoji.ui.SquareImageView;
import com.tencent.mm.protocal.protobuf.EmotionDonor;
import com.tencent.mm.protocal.protobuf.GetEmotionRewardResponse;
import com.tencent.mm.protocal.protobuf.bmu;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.emotion.o;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.widget.MMLoadScrollView.a;
import java.io.IOException;
import java.util.LinkedList;

public class EmojiStoreV2RewardDetailUI
  extends MMActivity
  implements AbsListView.OnScrollListener, i
{
  private View agA;
  private MMHandler czp;
  private boolean isLoading;
  private ListView mListView;
  private String rcE;
  private String rcq;
  private int ree;
  private GetEmotionRewardResponse rhu;
  private String rkP;
  private String rkQ;
  private ImageView rkR;
  private TextView rkS;
  private TextView rkT;
  private TextView rkU;
  private View rkV;
  private View rkW;
  private a rkX;
  private bmu rkY;
  private byte[] rkZ;
  private n rla;
  private MMLoadScrollView.a rlb;
  
  public EmojiStoreV2RewardDetailUI()
  {
    AppMethodBeat.i(109253);
    this.isLoading = false;
    this.ree = -1;
    this.czp = new MMHandler()
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
    this.rlb = new MMLoadScrollView.a()
    {
      public final void cIe()
      {
        AppMethodBeat.i(109245);
        Log.i("MicroMsg.emoji.EmojiStoreV2RewardDetailUI", "onBottom");
        EmojiStoreV2RewardDetailUI.b(EmojiStoreV2RewardDetailUI.this);
        AppMethodBeat.o(109245);
      }
    };
    AppMethodBeat.o(109253);
  }
  
  private void cId()
  {
    AppMethodBeat.i(109258);
    this.rla = new n(this.rcq, this.rkZ);
    g.aAg().hqi.a(this.rla, 0);
    AppMethodBeat.o(109258);
  }
  
  private void lA(boolean paramBoolean)
  {
    AppMethodBeat.i(109259);
    if ((!this.isLoading) && (this.ree != 0))
    {
      cId();
      this.isLoading = true;
      if (paramBoolean) {
        this.czp.sendEmptyMessageDelayed(1002, 200L);
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
    return 2131493971;
  }
  
  public void initView()
  {
    AppMethodBeat.i(109257);
    setMMTitle(2131758649);
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
    this.agA = aa.jQ(getContext()).inflate(2131493972, null);
    this.rkR = ((ImageView)this.agA.findViewById(2131299525));
    this.rkS = ((TextView)this.agA.findViewById(2131306170));
    this.rkT = ((TextView)this.agA.findViewById(2131299526));
    this.rkU = ((TextView)this.agA.findViewById(2131307056));
    this.rkV = findViewById(2131307157);
    this.mListView = ((ListView)findViewById(2131302291));
    this.rkW = aa.jQ(getContext()).inflate(2131493953, null);
    this.rkW.setVisibility(8);
    this.mListView.addHeaderView(this.agA);
    this.mListView.addFooterView(this.rkW);
    this.rkX = new a(this);
    this.mListView.setAdapter(this.rkX);
    this.mListView.setOnScrollListener(this);
    AppMethodBeat.o(109257);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(109254);
    super.onCreate(paramBundle);
    this.rcq = getIntent().getStringExtra("extra_id");
    this.rcE = getIntent().getStringExtra("extra_name");
    this.rkP = getIntent().getStringExtra("extra_iconurl");
    this.rkQ = getIntent().getStringExtra("name");
    initView();
    this.rhu = k.getEmojiStorageMgr().OpS.blu(this.rcq);
    cId();
    com.tencent.mm.av.q.bcV().a(this.rkP, this.rkR, e.fQ(this.rcq, this.rkP));
    this.rkS.setText(this.rcE);
    this.rkT.setText(this.rkQ);
    if (this.rkY != null)
    {
      this.rkX.Z(this.rkY.Donors);
      this.rkX.rle = true;
    }
    if (this.rhu != null) {
      this.rkU.setText(getString(2131758650, new Object[] { Integer.valueOf(this.rhu.DonorNum) }));
    }
    g.aAg().hqi.a(299, this);
    AppMethodBeat.o(109254);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(109256);
    super.onDestroy();
    g.aAg().hqi.b(299, this);
    com.tencent.mm.av.q.bcV().onScrollStateChanged(0);
    AppMethodBeat.o(109256);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(109255);
    super.onPause();
    AppMethodBeat.o(109255);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    int i = 1;
    AppMethodBeat.i(109260);
    this.isLoading = false;
    if (this.rkW != null)
    {
      this.rkW.setVisibility(8);
      this.czp.removeMessages(1002);
      this.czp.sendEmptyMessageDelayed(1001, 200L);
    }
    switch (paramq.getType())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(109260);
      return;
      paramString = (n)paramq;
      if ((paramInt1 == 0) || (paramInt1 == 4))
      {
        this.rkZ = paramString.rcY;
        if (paramInt2 == 0)
        {
          this.ree = 0;
          if (paramString.cGw() != null)
          {
            this.rkX.Z(paramString.cGw().Donors);
            AppMethodBeat.o(109260);
          }
        }
        else if (paramInt2 == 2)
        {
          this.ree = 2;
          if (paramString.cGw() != null) {
            this.rkX.Z(paramString.cGw().Donors);
          }
          paramInt1 = i;
          if (this.rkX != null)
          {
            paramInt1 = i;
            if (this.agA != null)
            {
              paramString = this.rkX;
              paramInt1 = paramString.rjH;
              paramInt2 = paramString.omS + paramInt1;
              int j = this.agA.getHeight();
              int k = com.tencent.mm.cb.a.jo(this);
              Log.i("MicroMsg.emoji.EmojiStoreV2RewardDetailUI", "item:%d header:%d window:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(j), Integer.valueOf(k) });
              paramInt1 = i;
              if (k > paramInt2 * this.rkX.getCount() + j) {
                paramInt1 = 0;
              }
            }
          }
          if (paramInt1 == 0)
          {
            lA(false);
            AppMethodBeat.o(109260);
          }
        }
        else if (paramInt2 == 3)
        {
          this.ree = 1;
          this.rkZ = null;
          this.rkX.rle = true;
          lA(false);
          AppMethodBeat.o(109260);
        }
      }
      else
      {
        Log.w("MicroMsg.emoji.EmojiStoreV2RewardDetailUI", "unknow errType:%d", new Object[] { Integer.valueOf(paramInt1) });
      }
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    AppMethodBeat.i(109261);
    if ((paramInt == 0) && (paramAbsListView.getLastVisiblePosition() == paramAbsListView.getCount() - 1))
    {
      if ((this.ree == 0) || (this.isLoading))
      {
        Log.d("MicroMsg.emoji.EmojiStoreV2RewardDetailUI", "No More List.");
        AppMethodBeat.o(109261);
        return;
      }
      lA(true);
      Log.i("MicroMsg.emoji.EmojiStoreV2RewardDetailUI", "[onScrollStateChanged] loadMoreData.");
      com.tencent.mm.av.q.bcV().onScrollStateChanged(paramInt);
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
    private Bitmap dku;
    private Context mContext;
    private int mNumColumns;
    int omS;
    private int qXG;
    int rjH;
    private LinkedList<EmotionDonor> rld;
    boolean rle;
    
    public a(Context paramContext)
    {
      AppMethodBeat.i(109247);
      this.rle = false;
      this.mNumColumns = 1;
      this.dku = null;
      this.mContext = paramContext;
      this.rjH = com.tencent.mm.cb.a.aG(EmojiStoreV2RewardDetailUI.this.getContext(), 2131166256);
      int k = com.tencent.mm.cb.a.jn(EmojiStoreV2RewardDetailUI.this.getContext()) - com.tencent.mm.cb.a.aG(EmojiStoreV2RewardDetailUI.this.getContext(), 2131165498) * 2;
      int m = this.rjH;
      int n = com.tencent.mm.cb.a.aG(EmojiStoreV2RewardDetailUI.this.getContext(), 2131165508);
      int j = k / (m + n);
      int i = j;
      if (k - j * m - n * (j - 1) > m) {
        i = j + 1;
      }
      this.mNumColumns = i;
      this.qXG = com.tencent.mm.cb.a.jn(this.mContext);
      this.omS = ((int)((this.qXG - this.mNumColumns * this.rjH) / (this.mNumColumns + 1.0F)));
      try
      {
        this.dku = BackwardSupportUtil.BitmapFactory.decodeStream(this.mContext.getAssets().open("avatar/default_nor_avatar.png"), com.tencent.mm.cb.a.getDensity(null));
        AppMethodBeat.o(109247);
        return;
      }
      catch (IOException this$1)
      {
        Log.i("MicroMsg.emoji.EmojiStoreV2RewardDetailUI", "decode stream default avatar failed. %s", new Object[] { Util.getStack() });
        AppMethodBeat.o(109247);
      }
    }
    
    private EmotionDonor Gb(int paramInt)
    {
      AppMethodBeat.i(109250);
      if (this.rld != null) {
        if (this.rld != null) {
          break label33;
        }
      }
      label33:
      for (int i = 0; paramInt >= i; i = this.rld.size())
      {
        AppMethodBeat.o(109250);
        return null;
      }
      EmotionDonor localEmotionDonor = (EmotionDonor)this.rld.get(paramInt);
      AppMethodBeat.o(109250);
      return localEmotionDonor;
    }
    
    public final void Z(LinkedList<EmotionDonor> paramLinkedList)
    {
      AppMethodBeat.i(109248);
      if (this.rld == null) {
        this.rld = new LinkedList();
      }
      if (this.rle)
      {
        this.rld.clear();
        this.rle = false;
      }
      this.rld.addAll(paramLinkedList);
      notifyDataSetChanged();
      AppMethodBeat.o(109248);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(109249);
      if (this.rld == null) {}
      for (int i = 0; i > 0; i = this.rld.size())
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
        ((LinearLayout)localObject1).setBackgroundResource(2131235359);
        ((LinearLayout)localObject1).setOrientation(0);
        ((LinearLayout)localObject1).setLayoutParams(paramView);
        ((LinearLayout)localObject1).setPadding(0, 0, 0, this.omS);
        localObject2 = new EmojiStoreV2RewardDetailUI.b(EmojiStoreV2RewardDetailUI.this);
        ((EmojiStoreV2RewardDetailUI.b)localObject2).qXM = ((LinearLayout)localObject1);
        ((View)localObject1).setTag(localObject2);
        i = 0;
        for (;;)
        {
          paramViewGroup = (ViewGroup)localObject2;
          paramView = (View)localObject1;
          if (i >= this.mNumColumns) {
            break;
          }
          paramView = new LinearLayout.LayoutParams(this.rjH, this.rjH);
          paramView.leftMargin = this.omS;
          paramViewGroup = new SquareImageView(this.mContext);
          ((EmojiStoreV2RewardDetailUI.b)localObject2).qXM.addView(paramViewGroup, i, paramView);
          i += 1;
        }
      }
      paramViewGroup = (EmojiStoreV2RewardDetailUI.b)paramView.getTag();
      int i = 0;
      if (i < this.mNumColumns)
      {
        int j = this.mNumColumns;
        localObject1 = (SquareImageView)paramViewGroup.qXM.getChildAt(i);
        localObject2 = Gb(j * paramInt + i);
        if (localObject2 != null)
        {
          ((SquareImageView)localObject1).setVisibility(0);
          if (!Util.isNullOrNil(((EmotionDonor)localObject2).HeadUrl)) {
            com.tencent.mm.av.q.bcV().a(((EmotionDonor)localObject2).HeadUrl, (ImageView)localObject1, e.K(EmojiStoreV2RewardDetailUI.c(EmojiStoreV2RewardDetailUI.this), ((EmotionDonor)localObject2).HeadUrl, this.rjH));
          }
        }
        for (;;)
        {
          i += 1;
          break;
          ((SquareImageView)localObject1).setImageBitmap(this.dku);
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
    LinearLayout qXM;
    
    b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2RewardDetailUI
 * JD-Core Version:    0.7.0.1
 */