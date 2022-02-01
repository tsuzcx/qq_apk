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
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.e.e;
import com.tencent.mm.plugin.emoji.f.m;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.plugin.emoji.ui.SquareImageView;
import com.tencent.mm.protocal.protobuf.EmotionDonor;
import com.tencent.mm.protocal.protobuf.GetEmotionRewardResponse;
import com.tencent.mm.protocal.protobuf.bbf;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.be;
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
  private aq gNm;
  private boolean isLoading;
  private ListView mListView;
  private String pLX;
  private String pMl;
  private int pNK;
  private GetEmotionRewardResponse pQv;
  private String pTQ;
  private String pTR;
  private ImageView pTS;
  private TextView pTT;
  private TextView pTU;
  private TextView pTV;
  private View pTW;
  private View pTX;
  private a pTY;
  private bbf pTZ;
  private byte[] pUa;
  private m pUb;
  private MMLoadScrollView.a pUc;
  
  public EmojiStoreV2RewardDetailUI()
  {
    AppMethodBeat.i(109253);
    this.isLoading = false;
    this.pNK = -1;
    this.gNm = new aq()
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
    this.pUc = new MMLoadScrollView.a()
    {
      public final void ckd()
      {
        AppMethodBeat.i(109245);
        ae.i("MicroMsg.emoji.EmojiStoreV2RewardDetailUI", "onBottom");
        EmojiStoreV2RewardDetailUI.b(EmojiStoreV2RewardDetailUI.this);
        AppMethodBeat.o(109245);
      }
    };
    AppMethodBeat.o(109253);
  }
  
  private void ckc()
  {
    AppMethodBeat.i(109258);
    this.pUb = new m(this.pLX, this.pUa);
    g.ajQ().gDv.a(this.pUb, 0);
    AppMethodBeat.o(109258);
  }
  
  private void ky(boolean paramBoolean)
  {
    AppMethodBeat.i(109259);
    if ((!this.isLoading) && (this.pNK != 0))
    {
      ckc();
      this.isLoading = true;
      if (paramBoolean) {
        this.gNm.sendEmptyMessageDelayed(1002, 200L);
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
    this.agn = z.jV(getContext()).inflate(2131493818, null);
    this.pTS = ((ImageView)this.agn.findViewById(2131299022));
    this.pTT = ((TextView)this.agn.findViewById(2131303438));
    this.pTU = ((TextView)this.agn.findViewById(2131299023));
    this.pTV = ((TextView)this.agn.findViewById(2131304156));
    this.pTW = findViewById(2131304239);
    this.mListView = ((ListView)findViewById(2131300717));
    this.pTX = z.jV(getContext()).inflate(2131493799, null);
    this.pTX.setVisibility(8);
    this.mListView.addHeaderView(this.agn);
    this.mListView.addFooterView(this.pTX);
    this.pTY = new a(this);
    this.mListView.setAdapter(this.pTY);
    this.mListView.setOnScrollListener(this);
    AppMethodBeat.o(109257);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(109254);
    super.onCreate(paramBundle);
    this.pLX = getIntent().getStringExtra("extra_id");
    this.pMl = getIntent().getStringExtra("extra_name");
    this.pTQ = getIntent().getStringExtra("extra_iconurl");
    this.pTR = getIntent().getStringExtra("name");
    initView();
    this.pQv = k.getEmojiStorageMgr().JfZ.aWv(this.pLX);
    ckc();
    com.tencent.mm.av.q.aJb().a(this.pTQ, this.pTS, e.fy(this.pLX, this.pTQ));
    this.pTT.setText(this.pMl);
    this.pTU.setText(this.pTR);
    if (this.pTZ != null)
    {
      this.pTY.Y(this.pTZ.Donors);
      this.pTY.pUf = true;
    }
    if (this.pQv != null) {
      this.pTV.setText(getString(2131758356, new Object[] { Integer.valueOf(this.pQv.DonorNum) }));
    }
    g.ajQ().gDv.a(299, this);
    AppMethodBeat.o(109254);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(109256);
    super.onDestroy();
    g.ajQ().gDv.b(299, this);
    com.tencent.mm.av.q.aJb().cp(0);
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
    if (this.pTX != null)
    {
      this.pTX.setVisibility(8);
      this.gNm.removeMessages(1002);
      this.gNm.sendEmptyMessageDelayed(1001, 200L);
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
        this.pUa = paramString.pME;
        if (paramInt2 == 0)
        {
          this.pNK = 0;
          if (paramString.ciy() != null)
          {
            this.pTY.Y(paramString.ciy().Donors);
            AppMethodBeat.o(109260);
          }
        }
        else if (paramInt2 == 2)
        {
          this.pNK = 2;
          if (paramString.ciy() != null) {
            this.pTY.Y(paramString.ciy().Donors);
          }
          paramInt1 = i;
          if (this.pTY != null)
          {
            paramInt1 = i;
            if (this.agn != null)
            {
              paramString = this.pTY;
              paramInt1 = paramString.pSI;
              paramInt2 = paramString.nbB + paramInt1;
              int j = this.agn.getHeight();
              int k = com.tencent.mm.cb.a.iv(this);
              ae.i("MicroMsg.emoji.EmojiStoreV2RewardDetailUI", "item:%d header:%d window:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(j), Integer.valueOf(k) });
              paramInt1 = i;
              if (k > paramInt2 * this.pTY.getCount() + j) {
                paramInt1 = 0;
              }
            }
          }
          if (paramInt1 == 0)
          {
            ky(false);
            AppMethodBeat.o(109260);
          }
        }
        else if (paramInt2 == 3)
        {
          this.pNK = 1;
          this.pUa = null;
          this.pTY.pUf = true;
          ky(false);
          AppMethodBeat.o(109260);
        }
      }
      else
      {
        ae.w("MicroMsg.emoji.EmojiStoreV2RewardDetailUI", "unknow errType:%d", new Object[] { Integer.valueOf(paramInt1) });
      }
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    AppMethodBeat.i(109261);
    if ((paramInt == 0) && (paramAbsListView.getLastVisiblePosition() == paramAbsListView.getCount() - 1))
    {
      if ((this.pNK == 0) || (this.isLoading))
      {
        ae.d("MicroMsg.emoji.EmojiStoreV2RewardDetailUI", "No More List.");
        AppMethodBeat.o(109261);
        return;
      }
      ky(true);
      ae.i("MicroMsg.emoji.EmojiStoreV2RewardDetailUI", "[onScrollStateChanged] loadMoreData.");
      com.tencent.mm.av.q.aJb().cp(paramInt);
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
    private Bitmap cUb;
    private Context mContext;
    private int mNumColumns;
    int nbB;
    private int pHU;
    int pSI;
    private LinkedList<EmotionDonor> pUe;
    boolean pUf;
    
    public a(Context paramContext)
    {
      AppMethodBeat.i(109247);
      this.pUf = false;
      this.mNumColumns = 1;
      this.cUb = null;
      this.mContext = paramContext;
      this.pSI = com.tencent.mm.cb.a.ax(EmojiStoreV2RewardDetailUI.this.getContext(), 2131166213);
      int k = com.tencent.mm.cb.a.iu(EmojiStoreV2RewardDetailUI.this.getContext()) - com.tencent.mm.cb.a.ax(EmojiStoreV2RewardDetailUI.this.getContext(), 2131165480) * 2;
      int m = this.pSI;
      int n = com.tencent.mm.cb.a.ax(EmojiStoreV2RewardDetailUI.this.getContext(), 2131165490);
      int j = k / (m + n);
      int i = j;
      if (k - j * m - n * (j - 1) > m) {
        i = j + 1;
      }
      this.mNumColumns = i;
      this.pHU = com.tencent.mm.cb.a.iu(this.mContext);
      this.nbB = ((int)((this.pHU - this.mNumColumns * this.pSI) / (this.mNumColumns + 1.0F)));
      try
      {
        this.cUb = BackwardSupportUtil.b.b(this.mContext.getAssets().open("avatar/default_nor_avatar.png"), com.tencent.mm.cb.a.getDensity(null));
        AppMethodBeat.o(109247);
        return;
      }
      catch (IOException this$1)
      {
        ae.i("MicroMsg.emoji.EmojiStoreV2RewardDetailUI", "decode stream default avatar failed. %s", new Object[] { bu.fpN() });
        AppMethodBeat.o(109247);
      }
    }
    
    private EmotionDonor Cq(int paramInt)
    {
      AppMethodBeat.i(109250);
      if (this.pUe != null) {
        if (this.pUe != null) {
          break label33;
        }
      }
      label33:
      for (int i = 0; paramInt >= i; i = this.pUe.size())
      {
        AppMethodBeat.o(109250);
        return null;
      }
      EmotionDonor localEmotionDonor = (EmotionDonor)this.pUe.get(paramInt);
      AppMethodBeat.o(109250);
      return localEmotionDonor;
    }
    
    public final void Y(LinkedList<EmotionDonor> paramLinkedList)
    {
      AppMethodBeat.i(109248);
      if (this.pUe == null) {
        this.pUe = new LinkedList();
      }
      if (this.pUf)
      {
        this.pUe.clear();
        this.pUf = false;
      }
      this.pUe.addAll(paramLinkedList);
      notifyDataSetChanged();
      AppMethodBeat.o(109248);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(109249);
      if (this.pUe == null) {}
      for (int i = 0; i > 0; i = this.pUe.size())
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
        ((LinearLayout)localObject1).setPadding(0, 0, 0, this.nbB);
        localObject2 = new EmojiStoreV2RewardDetailUI.b(EmojiStoreV2RewardDetailUI.this);
        ((EmojiStoreV2RewardDetailUI.b)localObject2).pIa = ((LinearLayout)localObject1);
        ((View)localObject1).setTag(localObject2);
        i = 0;
        for (;;)
        {
          paramViewGroup = (ViewGroup)localObject2;
          paramView = (View)localObject1;
          if (i >= this.mNumColumns) {
            break;
          }
          paramView = new LinearLayout.LayoutParams(this.pSI, this.pSI);
          paramView.leftMargin = this.nbB;
          paramViewGroup = new SquareImageView(this.mContext);
          ((EmojiStoreV2RewardDetailUI.b)localObject2).pIa.addView(paramViewGroup, i, paramView);
          i += 1;
        }
      }
      paramViewGroup = (EmojiStoreV2RewardDetailUI.b)paramView.getTag();
      int i = 0;
      if (i < this.mNumColumns)
      {
        int j = this.mNumColumns;
        localObject1 = (SquareImageView)paramViewGroup.pIa.getChildAt(i);
        localObject2 = Cq(j * paramInt + i);
        if (localObject2 != null)
        {
          ((SquareImageView)localObject1).setVisibility(0);
          if (!bu.isNullOrNil(((EmotionDonor)localObject2).HeadUrl)) {
            com.tencent.mm.av.q.aJb().a(((EmotionDonor)localObject2).HeadUrl, (ImageView)localObject1, e.L(EmojiStoreV2RewardDetailUI.c(EmojiStoreV2RewardDetailUI.this), ((EmotionDonor)localObject2).HeadUrl, this.pSI));
          }
        }
        for (;;)
        {
          i += 1;
          break;
          ((SquareImageView)localObject1).setImageBitmap(this.cUb);
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
    LinearLayout pIa;
    
    b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2RewardDetailUI
 * JD-Core Version:    0.7.0.1
 */