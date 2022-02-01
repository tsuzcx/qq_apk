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
import com.tencent.mm.an.i;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.emoji.e.e;
import com.tencent.mm.plugin.emoji.f.n;
import com.tencent.mm.plugin.emoji.i.c;
import com.tencent.mm.plugin.emoji.i.d;
import com.tencent.mm.plugin.emoji.i.e;
import com.tencent.mm.plugin.emoji.i.f;
import com.tencent.mm.plugin.emoji.i.h;
import com.tencent.mm.plugin.emoji.model.p;
import com.tencent.mm.plugin.emoji.ui.SquareImageView;
import com.tencent.mm.protocal.protobuf.akc;
import com.tencent.mm.protocal.protobuf.buf;
import com.tencent.mm.protocal.protobuf.buj;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.emotion.o;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ad;
import com.tencent.mm.ui.widget.MMLoadScrollView.a;
import java.io.IOException;
import java.util.LinkedList;

public class EmojiStoreV2RewardDetailUI
  extends MMActivity
  implements AbsListView.OnScrollListener, i
{
  private MMHandler cyl;
  private boolean isLoading;
  private View mL;
  private ListView mListView;
  private String uFJ;
  private String uFv;
  private int uHj;
  private buj uKD;
  private String uOb;
  private String uOc;
  private ImageView uOd;
  private TextView uOe;
  private TextView uOf;
  private TextView uOg;
  private View uOh;
  private View uOi;
  private a uOj;
  private buf uOk;
  private byte[] uOl;
  private n uOm;
  private MMLoadScrollView.a uOn;
  
  public EmojiStoreV2RewardDetailUI()
  {
    AppMethodBeat.i(109253);
    this.isLoading = false;
    this.uHj = -1;
    this.cyl = new MMHandler()
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
    this.uOn = new MMLoadScrollView.a()
    {
      public final void cWL()
      {
        AppMethodBeat.i(109245);
        Log.i("MicroMsg.emoji.EmojiStoreV2RewardDetailUI", "onBottom");
        EmojiStoreV2RewardDetailUI.b(EmojiStoreV2RewardDetailUI.this);
        AppMethodBeat.o(109245);
      }
    };
    AppMethodBeat.o(109253);
  }
  
  private void cWK()
  {
    AppMethodBeat.i(109258);
    this.uOm = new n(this.uFv, this.uOl);
    h.aHF().kcd.a(this.uOm, 0);
    AppMethodBeat.o(109258);
  }
  
  private void mL(boolean paramBoolean)
  {
    AppMethodBeat.i(109259);
    if ((!this.isLoading) && (this.uHj != 0))
    {
      cWK();
      this.isLoading = true;
      if (paramBoolean) {
        this.cyl.sendEmptyMessageDelayed(1002, 200L);
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
    return i.f.emoji_store_v2_reward_detail_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(109257);
    setMMTitle(i.h.emoji_store_reward_detail);
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
    this.mL = ad.kS(getContext()).inflate(i.f.emoji_store_v2_reward_header_bar, null);
    this.uOd = ((ImageView)this.mL.findViewById(i.e.designer_icon));
    this.uOe = ((TextView)this.mL.findViewById(i.e.product_name));
    this.uOf = ((TextView)this.mL.findViewById(i.e.designer_name));
    this.uOg = ((TextView)this.mL.findViewById(i.e.reward_count));
    this.uOh = findViewById(i.e.root);
    this.mListView = ((ListView)findViewById(i.e.header_gridview));
    this.uOi = ad.kS(getContext()).inflate(i.f.emoji_store_load_more, null);
    this.uOi.setVisibility(8);
    this.mListView.addHeaderView(this.mL);
    this.mListView.addFooterView(this.uOi);
    this.uOj = new a(this);
    this.mListView.setAdapter(this.uOj);
    this.mListView.setOnScrollListener(this);
    AppMethodBeat.o(109257);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(109254);
    super.onCreate(paramBundle);
    this.uFv = getIntent().getStringExtra("extra_id");
    this.uFJ = getIntent().getStringExtra("extra_name");
    this.uOb = getIntent().getStringExtra("extra_iconurl");
    this.uOc = getIntent().getStringExtra("name");
    initView();
    this.uKD = p.getEmojiStorageMgr().VFM.bxU(this.uFv);
    cWK();
    com.tencent.mm.ay.q.bml().a(this.uOb, this.uOd, e.gd(this.uFv, this.uOb));
    this.uOe.setText(this.uFJ);
    this.uOf.setText(this.uOc);
    if (this.uOk != null)
    {
      this.uOj.X(this.uOk.Teh);
      this.uOj.uOq = true;
    }
    if (this.uKD != null) {
      this.uOg.setText(getString(i.h.emoji_store_reward_info, new Object[] { Integer.valueOf(this.uKD.Teg) }));
    }
    h.aHF().kcd.a(299, this);
    AppMethodBeat.o(109254);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(109256);
    super.onDestroy();
    h.aHF().kcd.b(299, this);
    com.tencent.mm.ay.q.bml().onScrollStateChanged(0);
    AppMethodBeat.o(109256);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(109255);
    super.onPause();
    AppMethodBeat.o(109255);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    int i = 1;
    AppMethodBeat.i(109260);
    this.isLoading = false;
    if (this.uOi != null)
    {
      this.uOi.setVisibility(8);
      this.cyl.removeMessages(1002);
      this.cyl.sendEmptyMessageDelayed(1001, 200L);
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
        this.uOl = paramString.uGe;
        if (paramInt2 == 0)
        {
          this.uHj = 0;
          if (paramString.cVf() != null)
          {
            this.uOj.X(paramString.cVf().Teh);
            AppMethodBeat.o(109260);
          }
        }
        else if (paramInt2 == 2)
        {
          this.uHj = 2;
          if (paramString.cVf() != null) {
            this.uOj.X(paramString.cVf().Teh);
          }
          paramInt1 = i;
          if (this.uOj != null)
          {
            paramInt1 = i;
            if (this.mL != null)
            {
              paramString = this.uOj;
              paramInt1 = paramString.uMU;
              paramInt2 = paramString.sJu + paramInt1;
              int j = this.mL.getHeight();
              int k = com.tencent.mm.ci.a.ks(this);
              Log.i("MicroMsg.emoji.EmojiStoreV2RewardDetailUI", "item:%d header:%d window:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(j), Integer.valueOf(k) });
              paramInt1 = i;
              if (k > paramInt2 * this.uOj.getCount() + j) {
                paramInt1 = 0;
              }
            }
          }
          if (paramInt1 == 0)
          {
            mL(false);
            AppMethodBeat.o(109260);
          }
        }
        else if (paramInt2 == 3)
        {
          this.uHj = 1;
          this.uOl = null;
          this.uOj.uOq = true;
          mL(false);
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
      if ((this.uHj == 0) || (this.isLoading))
      {
        Log.d("MicroMsg.emoji.EmojiStoreV2RewardDetailUI", "No More List.");
        AppMethodBeat.o(109261);
        return;
      }
      mL(true);
      Log.i("MicroMsg.emoji.EmojiStoreV2RewardDetailUI", "[onScrollStateChanged] loadMoreData.");
      com.tencent.mm.ay.q.bml().onScrollStateChanged(paramInt);
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
    private Bitmap fcd;
    private Context mContext;
    private int mNumColumns;
    int sJu;
    private int uAv;
    int uMU;
    private LinkedList<akc> uOp;
    boolean uOq;
    
    public a(Context paramContext)
    {
      AppMethodBeat.i(109247);
      this.uOq = false;
      this.mNumColumns = 1;
      this.fcd = null;
      this.mContext = paramContext;
      this.uMU = com.tencent.mm.ci.a.aY(EmojiStoreV2RewardDetailUI.this.getContext(), i.c.emoji_donors_avatar_size);
      int k = com.tencent.mm.ci.a.kr(EmojiStoreV2RewardDetailUI.this.getContext()) - com.tencent.mm.ci.a.aY(EmojiStoreV2RewardDetailUI.this.getContext(), i.c.LargePadding) * 2;
      int m = this.uMU;
      int n = com.tencent.mm.ci.a.aY(EmojiStoreV2RewardDetailUI.this.getContext(), i.c.LittlePadding);
      int j = k / (m + n);
      int i = j;
      if (k - j * m - n * (j - 1) > m) {
        i = j + 1;
      }
      this.mNumColumns = i;
      this.uAv = com.tencent.mm.ci.a.kr(this.mContext);
      this.sJu = ((int)((this.uAv - this.mNumColumns * this.uMU) / (this.mNumColumns + 1.0F)));
      try
      {
        this.fcd = BackwardSupportUtil.BitmapFactory.decodeStream(this.mContext.getAssets().open("avatar/default_nor_avatar.png"), com.tencent.mm.ci.a.getDensity(null));
        AppMethodBeat.o(109247);
        return;
      }
      catch (IOException this$1)
      {
        Log.i("MicroMsg.emoji.EmojiStoreV2RewardDetailUI", "decode stream default avatar failed. %s", new Object[] { Util.getStack() });
        AppMethodBeat.o(109247);
      }
    }
    
    private akc JI(int paramInt)
    {
      AppMethodBeat.i(109250);
      if (this.uOp != null) {
        if (this.uOp != null) {
          break label33;
        }
      }
      label33:
      for (int i = 0; paramInt >= i; i = this.uOp.size())
      {
        AppMethodBeat.o(109250);
        return null;
      }
      akc localakc = (akc)this.uOp.get(paramInt);
      AppMethodBeat.o(109250);
      return localakc;
    }
    
    public final void X(LinkedList<akc> paramLinkedList)
    {
      AppMethodBeat.i(109248);
      if (this.uOp == null) {
        this.uOp = new LinkedList();
      }
      if (this.uOq)
      {
        this.uOp.clear();
        this.uOq = false;
      }
      this.uOp.addAll(paramLinkedList);
      notifyDataSetChanged();
      AppMethodBeat.o(109248);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(109249);
      if (this.uOp == null) {}
      for (int i = 0; i > 0; i = this.uOp.size())
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
        ((LinearLayout)localObject1).setBackgroundResource(i.d.transparent_background);
        ((LinearLayout)localObject1).setOrientation(0);
        ((LinearLayout)localObject1).setLayoutParams(paramView);
        ((LinearLayout)localObject1).setPadding(0, 0, 0, this.sJu);
        localObject2 = new EmojiStoreV2RewardDetailUI.b(EmojiStoreV2RewardDetailUI.this);
        ((EmojiStoreV2RewardDetailUI.b)localObject2).uAB = ((LinearLayout)localObject1);
        ((View)localObject1).setTag(localObject2);
        i = 0;
        for (;;)
        {
          paramViewGroup = (ViewGroup)localObject2;
          paramView = (View)localObject1;
          if (i >= this.mNumColumns) {
            break;
          }
          paramView = new LinearLayout.LayoutParams(this.uMU, this.uMU);
          paramView.leftMargin = this.sJu;
          paramViewGroup = new SquareImageView(this.mContext);
          ((EmojiStoreV2RewardDetailUI.b)localObject2).uAB.addView(paramViewGroup, i, paramView);
          i += 1;
        }
      }
      paramViewGroup = (EmojiStoreV2RewardDetailUI.b)paramView.getTag();
      int i = 0;
      if (i < this.mNumColumns)
      {
        int j = this.mNumColumns;
        localObject1 = (SquareImageView)paramViewGroup.uAB.getChildAt(i);
        localObject2 = JI(j * paramInt + i);
        if (localObject2 != null)
        {
          ((SquareImageView)localObject1).setVisibility(0);
          if (!Util.isNullOrNil(((akc)localObject2).SuR)) {
            com.tencent.mm.ay.q.bml().a(((akc)localObject2).SuR, (ImageView)localObject1, e.O(EmojiStoreV2RewardDetailUI.c(EmojiStoreV2RewardDetailUI.this), ((akc)localObject2).SuR, this.uMU));
          }
        }
        for (;;)
        {
          i += 1;
          break;
          ((SquareImageView)localObject1).setImageBitmap(this.fcd);
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
    LinearLayout uAB;
    
    b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2RewardDetailUI
 * JD-Core Version:    0.7.0.1
 */