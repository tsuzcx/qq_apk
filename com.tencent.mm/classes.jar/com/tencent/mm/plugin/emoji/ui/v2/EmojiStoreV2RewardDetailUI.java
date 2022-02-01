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
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.plugin.emoji.e.e;
import com.tencent.mm.plugin.emoji.f.m;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.plugin.emoji.ui.SquareImageView;
import com.tencent.mm.protocal.protobuf.EmotionDonor;
import com.tencent.mm.protocal.protobuf.GetEmotionRewardResponse;
import com.tencent.mm.protocal.protobuf.awr;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.az;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMLoadScrollView.a;
import com.tencent.mm.ui.z;
import java.io.IOException;
import java.util.LinkedList;

public class EmojiStoreV2RewardDetailUI
  extends MMActivity
  implements AbsListView.OnScrollListener, com.tencent.mm.ak.g
{
  private View aew;
  private ao gqT;
  private boolean isLoading;
  private ListView mListView;
  private String pbJ;
  private String pbX;
  private int pdE;
  private GetEmotionRewardResponse pgo;
  private String pjL;
  private String pjM;
  private ImageView pjN;
  private TextView pjO;
  private TextView pjP;
  private TextView pjQ;
  private View pjR;
  private View pjS;
  private a pjT;
  private awr pjU;
  private byte[] pjV;
  private m pjW;
  private MMLoadScrollView.a pjX;
  
  public EmojiStoreV2RewardDetailUI()
  {
    AppMethodBeat.i(109253);
    this.isLoading = false;
    this.pdE = -1;
    this.gqT = new ao()
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
    this.pjX = new MMLoadScrollView.a()
    {
      public final void cek()
      {
        AppMethodBeat.i(109245);
        ac.i("MicroMsg.emoji.EmojiStoreV2RewardDetailUI", "onBottom");
        EmojiStoreV2RewardDetailUI.b(EmojiStoreV2RewardDetailUI.this);
        AppMethodBeat.o(109245);
      }
    };
    AppMethodBeat.o(109253);
  }
  
  private void cej()
  {
    AppMethodBeat.i(109258);
    this.pjW = new m(this.pbJ, this.pjV);
    com.tencent.mm.kernel.g.agQ().ghe.a(this.pjW, 0);
    AppMethodBeat.o(109258);
  }
  
  private void ko(boolean paramBoolean)
  {
    AppMethodBeat.i(109259);
    if ((!this.isLoading) && (this.pdE != 0))
    {
      cej();
      this.isLoading = true;
      if (paramBoolean) {
        this.gqT.sendEmptyMessageDelayed(1002, 200L);
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
    this.aew = z.jD(getContext()).inflate(2131493818, null);
    this.pjN = ((ImageView)this.aew.findViewById(2131299022));
    this.pjO = ((TextView)this.aew.findViewById(2131303438));
    this.pjP = ((TextView)this.aew.findViewById(2131299023));
    this.pjQ = ((TextView)this.aew.findViewById(2131304156));
    this.pjR = findViewById(2131304239);
    this.mListView = ((ListView)findViewById(2131300717));
    this.pjS = z.jD(getContext()).inflate(2131493799, null);
    this.pjS.setVisibility(8);
    this.mListView.addHeaderView(this.aew);
    this.mListView.addFooterView(this.pjS);
    this.pjT = new a(this);
    this.mListView.setAdapter(this.pjT);
    this.mListView.setOnScrollListener(this);
    AppMethodBeat.o(109257);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(109254);
    super.onCreate(paramBundle);
    this.pbJ = getIntent().getStringExtra("extra_id");
    this.pbX = getIntent().getStringExtra("extra_name");
    this.pjL = getIntent().getStringExtra("extra_iconurl");
    this.pjM = getIntent().getStringExtra("name");
    initView();
    this.pgo = k.getEmojiStorageMgr().GYe.aPd(this.pbJ);
    cej();
    com.tencent.mm.av.o.aFB().a(this.pjL, this.pjN, e.fk(this.pbJ, this.pjL));
    this.pjO.setText(this.pbX);
    this.pjP.setText(this.pjM);
    if (this.pjU != null)
    {
      this.pjT.X(this.pjU.Donors);
      this.pjT.pka = true;
    }
    if (this.pgo != null) {
      this.pjQ.setText(getString(2131758356, new Object[] { Integer.valueOf(this.pgo.DonorNum) }));
    }
    com.tencent.mm.kernel.g.agQ().ghe.a(299, this);
    AppMethodBeat.o(109254);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(109256);
    super.onDestroy();
    com.tencent.mm.kernel.g.agQ().ghe.b(299, this);
    com.tencent.mm.av.o.aFB().cp(0);
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
    if (this.pjS != null)
    {
      this.pjS.setVisibility(8);
      this.gqT.removeMessages(1002);
      this.gqT.sendEmptyMessageDelayed(1001, 200L);
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
        this.pjV = paramString.pcq;
        if (paramInt2 == 0)
        {
          this.pdE = 0;
          if (paramString.ccE() != null)
          {
            this.pjT.X(paramString.ccE().Donors);
            AppMethodBeat.o(109260);
          }
        }
        else if (paramInt2 == 2)
        {
          this.pdE = 2;
          if (paramString.ccE() != null) {
            this.pjT.X(paramString.ccE().Donors);
          }
          paramInt1 = i;
          if (this.pjT != null)
          {
            paramInt1 = i;
            if (this.aew != null)
            {
              paramString = this.pjT;
              paramInt1 = paramString.piD;
              paramInt2 = paramString.mvQ + paramInt1;
              int j = this.aew.getHeight();
              int k = com.tencent.mm.cc.a.ih(this);
              ac.i("MicroMsg.emoji.EmojiStoreV2RewardDetailUI", "item:%d header:%d window:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(j), Integer.valueOf(k) });
              paramInt1 = i;
              if (k > paramInt2 * this.pjT.getCount() + j) {
                paramInt1 = 0;
              }
            }
          }
          if (paramInt1 == 0)
          {
            ko(false);
            AppMethodBeat.o(109260);
          }
        }
        else if (paramInt2 == 3)
        {
          this.pdE = 1;
          this.pjV = null;
          this.pjT.pka = true;
          ko(false);
          AppMethodBeat.o(109260);
        }
      }
      else
      {
        ac.w("MicroMsg.emoji.EmojiStoreV2RewardDetailUI", "unknow errType:%d", new Object[] { Integer.valueOf(paramInt1) });
      }
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    AppMethodBeat.i(109261);
    if ((paramInt == 0) && (paramAbsListView.getLastVisiblePosition() == paramAbsListView.getCount() - 1))
    {
      if ((this.pdE == 0) || (this.isLoading))
      {
        ac.d("MicroMsg.emoji.EmojiStoreV2RewardDetailUI", "No More List.");
        AppMethodBeat.o(109261);
        return;
      }
      ko(true);
      ac.i("MicroMsg.emoji.EmojiStoreV2RewardDetailUI", "[onScrollStateChanged] loadMoreData.");
      com.tencent.mm.av.o.aFB().cp(paramInt);
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
    private Bitmap cIi;
    private Context mContext;
    private int mNumColumns;
    int mvQ;
    private int oXG;
    int piD;
    private LinkedList<EmotionDonor> pjZ;
    boolean pka;
    
    public a(Context paramContext)
    {
      AppMethodBeat.i(109247);
      this.pka = false;
      this.mNumColumns = 1;
      this.cIi = null;
      this.mContext = paramContext;
      this.piD = com.tencent.mm.cc.a.au(EmojiStoreV2RewardDetailUI.this.getContext(), 2131166213);
      int k = com.tencent.mm.cc.a.ig(EmojiStoreV2RewardDetailUI.this.getContext()) - com.tencent.mm.cc.a.au(EmojiStoreV2RewardDetailUI.this.getContext(), 2131165480) * 2;
      int m = this.piD;
      int n = com.tencent.mm.cc.a.au(EmojiStoreV2RewardDetailUI.this.getContext(), 2131165490);
      int j = k / (m + n);
      int i = j;
      if (k - j * m - n * (j - 1) > m) {
        i = j + 1;
      }
      this.mNumColumns = i;
      this.oXG = com.tencent.mm.cc.a.ig(this.mContext);
      this.mvQ = ((int)((this.oXG - this.mNumColumns * this.piD) / (this.mNumColumns + 1.0F)));
      try
      {
        this.cIi = BackwardSupportUtil.b.b(this.mContext.getAssets().open("avatar/default_nor_avatar.png"), com.tencent.mm.cc.a.getDensity(null));
        AppMethodBeat.o(109247);
        return;
      }
      catch (IOException this$1)
      {
        ac.i("MicroMsg.emoji.EmojiStoreV2RewardDetailUI", "decode stream default avatar failed. %s", new Object[] { bs.eWi() });
        AppMethodBeat.o(109247);
      }
    }
    
    private EmotionDonor Bw(int paramInt)
    {
      AppMethodBeat.i(109250);
      if (this.pjZ != null) {
        if (this.pjZ != null) {
          break label33;
        }
      }
      label33:
      for (int i = 0; paramInt >= i; i = this.pjZ.size())
      {
        AppMethodBeat.o(109250);
        return null;
      }
      EmotionDonor localEmotionDonor = (EmotionDonor)this.pjZ.get(paramInt);
      AppMethodBeat.o(109250);
      return localEmotionDonor;
    }
    
    public final void X(LinkedList<EmotionDonor> paramLinkedList)
    {
      AppMethodBeat.i(109248);
      if (this.pjZ == null) {
        this.pjZ = new LinkedList();
      }
      if (this.pka)
      {
        this.pjZ.clear();
        this.pka = false;
      }
      this.pjZ.addAll(paramLinkedList);
      notifyDataSetChanged();
      AppMethodBeat.o(109248);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(109249);
      if (this.pjZ == null) {}
      for (int i = 0; i > 0; i = this.pjZ.size())
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
        ((LinearLayout)localObject1).setPadding(0, 0, 0, this.mvQ);
        localObject2 = new EmojiStoreV2RewardDetailUI.b(EmojiStoreV2RewardDetailUI.this);
        ((EmojiStoreV2RewardDetailUI.b)localObject2).oXM = ((LinearLayout)localObject1);
        ((View)localObject1).setTag(localObject2);
        i = 0;
        for (;;)
        {
          paramViewGroup = (ViewGroup)localObject2;
          paramView = (View)localObject1;
          if (i >= this.mNumColumns) {
            break;
          }
          paramView = new LinearLayout.LayoutParams(this.piD, this.piD);
          paramView.leftMargin = this.mvQ;
          paramViewGroup = new SquareImageView(this.mContext);
          ((EmojiStoreV2RewardDetailUI.b)localObject2).oXM.addView(paramViewGroup, i, paramView);
          i += 1;
        }
      }
      paramViewGroup = (EmojiStoreV2RewardDetailUI.b)paramView.getTag();
      int i = 0;
      if (i < this.mNumColumns)
      {
        int j = this.mNumColumns;
        localObject1 = (SquareImageView)paramViewGroup.oXM.getChildAt(i);
        localObject2 = Bw(j * paramInt + i);
        if (localObject2 != null)
        {
          ((SquareImageView)localObject1).setVisibility(0);
          if (!bs.isNullOrNil(((EmotionDonor)localObject2).HeadUrl)) {
            com.tencent.mm.av.o.aFB().a(((EmotionDonor)localObject2).HeadUrl, (ImageView)localObject1, e.K(EmojiStoreV2RewardDetailUI.c(EmojiStoreV2RewardDetailUI.this), ((EmotionDonor)localObject2).HeadUrl, this.piD));
          }
        }
        for (;;)
        {
          i += 1;
          break;
          ((SquareImageView)localObject1).setImageBitmap(this.cIi);
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
    LinearLayout oXM;
    
    b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2RewardDetailUI
 * JD-Core Version:    0.7.0.1
 */