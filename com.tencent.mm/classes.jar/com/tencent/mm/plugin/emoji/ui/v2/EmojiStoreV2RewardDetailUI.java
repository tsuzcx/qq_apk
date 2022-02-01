package com.tencent.mm.plugin.emoji.ui.v2;

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
import com.tencent.mm.am.p;
import com.tencent.mm.kernel.c;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.plugin.emoji.e.n;
import com.tencent.mm.plugin.emoji.h.c;
import com.tencent.mm.plugin.emoji.h.d;
import com.tencent.mm.plugin.emoji.h.e;
import com.tencent.mm.plugin.emoji.h.f;
import com.tencent.mm.plugin.emoji.h.h;
import com.tencent.mm.plugin.emoji.mgr.e;
import com.tencent.mm.plugin.emoji.ui.SquareImageView;
import com.tencent.mm.protocal.protobuf.cix;
import com.tencent.mm.protocal.protobuf.cja;
import com.tencent.mm.protocal.protobuf.goi;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.emotion.o;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.widget.MMLoadScrollView.a;
import java.io.IOException;
import java.util.LinkedList;

public class EmojiStoreV2RewardDetailUI
  extends MMActivity
  implements AbsListView.OnScrollListener, com.tencent.mm.am.h
{
  private MMHandler eqE;
  private boolean isLoading;
  private ListView mListView;
  private View nJ;
  private String xNX;
  private String xOl;
  private int xPP;
  private goi xSZ;
  private String xWL;
  private String xWM;
  private ImageView xWN;
  private TextView xWO;
  private TextView xWP;
  private TextView xWQ;
  private View xWR;
  private View xWS;
  private a xWT;
  private cja xWU;
  private byte[] xWV;
  private n xWW;
  private MMLoadScrollView.a xWX;
  
  public EmojiStoreV2RewardDetailUI()
  {
    AppMethodBeat.i(109253);
    this.isLoading = false;
    this.xPP = -1;
    this.eqE = new MMHandler()
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
    this.xWX = new MMLoadScrollView.a()
    {
      public final void dCr()
      {
        AppMethodBeat.i(109245);
        Log.i("MicroMsg.emoji.EmojiStoreV2RewardDetailUI", "onBottom");
        EmojiStoreV2RewardDetailUI.b(EmojiStoreV2RewardDetailUI.this);
        AppMethodBeat.o(109245);
      }
    };
    AppMethodBeat.o(109253);
  }
  
  private void dCq()
  {
    AppMethodBeat.i(109258);
    this.xWW = new n(this.xNX, this.xWV);
    com.tencent.mm.kernel.h.baD().mCm.a(this.xWW, 0);
    AppMethodBeat.o(109258);
  }
  
  private void oi(boolean paramBoolean)
  {
    AppMethodBeat.i(109259);
    if ((!this.isLoading) && (this.xPP != 0))
    {
      dCq();
      this.isLoading = true;
      if (paramBoolean) {
        this.eqE.sendEmptyMessageDelayed(1002, 200L);
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
    return h.f.emoji_store_v2_reward_detail_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(109257);
    setMMTitle(h.h.emoji_store_reward_detail);
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
    this.nJ = af.mU(getContext()).inflate(h.f.emoji_store_v2_reward_header_bar, null);
    this.xWN = ((ImageView)this.nJ.findViewById(h.e.designer_icon));
    this.xWO = ((TextView)this.nJ.findViewById(h.e.product_name));
    this.xWP = ((TextView)this.nJ.findViewById(h.e.designer_name));
    this.xWQ = ((TextView)this.nJ.findViewById(h.e.reward_count));
    this.xWR = findViewById(h.e.root);
    this.mListView = ((ListView)findViewById(h.e.header_gridview));
    this.xWS = af.mU(getContext()).inflate(h.f.emoji_store_load_more, null);
    this.xWS.setVisibility(8);
    this.mListView.addHeaderView(this.nJ);
    this.mListView.addFooterView(this.xWS);
    this.xWT = new a(this);
    this.mListView.setAdapter(this.xWT);
    this.mListView.setOnScrollListener(this);
    AppMethodBeat.o(109257);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(109254);
    super.onCreate(paramBundle);
    this.xNX = getIntent().getStringExtra("extra_id");
    this.xOl = getIntent().getStringExtra("extra_name");
    this.xWL = getIntent().getStringExtra("extra_iconurl");
    this.xWM = getIntent().getStringExtra("name");
    initView();
    this.xSZ = com.tencent.mm.plugin.emoji.model.s.getEmojiStorageMgr().adjA.bzk(this.xNX);
    dCq();
    r.bKe().a(this.xWL, this.xWN, e.gJ(this.xNX, this.xWL));
    this.xWO.setText(this.xOl);
    this.xWP.setText(this.xWM);
    if (this.xWU != null)
    {
      this.xWT.aa(this.xWU.aarx);
      this.xWT.xXa = true;
    }
    if (this.xSZ != null) {
      this.xWQ.setText(getString(h.h.emoji_store_reward_info, new Object[] { Integer.valueOf(this.xSZ.aarw) }));
    }
    com.tencent.mm.kernel.h.baD().mCm.a(299, this);
    AppMethodBeat.o(109254);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(109256);
    super.onDestroy();
    com.tencent.mm.kernel.h.baD().mCm.b(299, this);
    r.bKe().onScrollStateChanged(0);
    AppMethodBeat.o(109256);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(109255);
    super.onPause();
    AppMethodBeat.o(109255);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    int i = 1;
    AppMethodBeat.i(109260);
    this.isLoading = false;
    if (this.xWS != null)
    {
      this.xWS.setVisibility(8);
      this.eqE.removeMessages(1002);
      this.eqE.sendEmptyMessageDelayed(1001, 200L);
    }
    switch (paramp.getType())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(109260);
      return;
      paramString = (n)paramp;
      if ((paramInt1 == 0) || (paramInt1 == 4))
      {
        this.xWV = paramString.xOH;
        if (paramInt2 == 0)
        {
          this.xPP = 0;
          if (paramString.dAE() != null)
          {
            this.xWT.aa(paramString.dAE().aarx);
            AppMethodBeat.o(109260);
          }
        }
        else if (paramInt2 == 2)
        {
          this.xPP = 2;
          if (paramString.dAE() != null) {
            this.xWT.aa(paramString.dAE().aarx);
          }
          paramInt1 = i;
          if (this.xWT != null)
          {
            paramInt1 = i;
            if (this.nJ != null)
            {
              paramString = this.xWT;
              paramInt1 = paramString.xVx;
              paramInt2 = paramString.vPy + paramInt1;
              int j = this.nJ.getHeight();
              int k = com.tencent.mm.cd.a.mt(this);
              Log.i("MicroMsg.emoji.EmojiStoreV2RewardDetailUI", "item:%d header:%d window:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(j), Integer.valueOf(k) });
              paramInt1 = i;
              if (k > paramInt2 * this.xWT.getCount() + j) {
                paramInt1 = 0;
              }
            }
          }
          if (paramInt1 == 0)
          {
            oi(false);
            AppMethodBeat.o(109260);
          }
        }
        else if (paramInt2 == 3)
        {
          this.xPP = 1;
          this.xWV = null;
          this.xWT.xXa = true;
          oi(false);
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
      if ((this.xPP == 0) || (this.isLoading))
      {
        Log.d("MicroMsg.emoji.EmojiStoreV2RewardDetailUI", "No More List.");
        AppMethodBeat.o(109261);
        return;
      }
      oi(true);
      Log.i("MicroMsg.emoji.EmojiStoreV2RewardDetailUI", "[onScrollStateChanged] loadMoreData.");
      r.bKe().onScrollStateChanged(paramInt);
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
    private Bitmap hfN;
    private Context mContext;
    private int mNumColumns;
    int vPy;
    private int xGY;
    int xVx;
    private LinkedList<cix> xWZ;
    boolean xXa;
    
    public a(Context paramContext)
    {
      AppMethodBeat.i(109247);
      this.xXa = false;
      this.mNumColumns = 1;
      this.hfN = null;
      this.mContext = paramContext;
      this.xVx = com.tencent.mm.cd.a.br(EmojiStoreV2RewardDetailUI.this.getContext(), h.c.emoji_donors_avatar_size);
      int k = com.tencent.mm.cd.a.ms(EmojiStoreV2RewardDetailUI.this.getContext()) - com.tencent.mm.cd.a.br(EmojiStoreV2RewardDetailUI.this.getContext(), h.c.LargePadding) * 2;
      int m = this.xVx;
      int n = com.tencent.mm.cd.a.br(EmojiStoreV2RewardDetailUI.this.getContext(), h.c.LittlePadding);
      int j = k / (m + n);
      int i = j;
      if (k - j * m - n * (j - 1) > m) {
        i = j + 1;
      }
      this.mNumColumns = i;
      this.xGY = com.tencent.mm.cd.a.ms(this.mContext);
      this.vPy = ((int)((this.xGY - this.mNumColumns * this.xVx) / (this.mNumColumns + 1.0F)));
      try
      {
        this.hfN = BackwardSupportUtil.BitmapFactory.decodeStream(this.mContext.getAssets().open("avatar/default_nor_avatar.png"), com.tencent.mm.cd.a.getDensity(null));
        AppMethodBeat.o(109247);
        return;
      }
      catch (IOException this$1)
      {
        Log.i("MicroMsg.emoji.EmojiStoreV2RewardDetailUI", "decode stream default avatar failed. %s", new Object[] { Util.getStack() });
        AppMethodBeat.o(109247);
      }
    }
    
    private cix Kt(int paramInt)
    {
      AppMethodBeat.i(109250);
      if (this.xWZ != null) {
        if (this.xWZ != null) {
          break label33;
        }
      }
      label33:
      for (int i = 0; paramInt >= i; i = this.xWZ.size())
      {
        AppMethodBeat.o(109250);
        return null;
      }
      cix localcix = (cix)this.xWZ.get(paramInt);
      AppMethodBeat.o(109250);
      return localcix;
    }
    
    public final void aa(LinkedList<cix> paramLinkedList)
    {
      AppMethodBeat.i(109248);
      if (this.xWZ == null) {
        this.xWZ = new LinkedList();
      }
      if (this.xXa)
      {
        this.xWZ.clear();
        this.xXa = false;
      }
      this.xWZ.addAll(paramLinkedList);
      notifyDataSetChanged();
      AppMethodBeat.o(109248);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(109249);
      if (this.xWZ == null) {}
      for (int i = 0; i > 0; i = this.xWZ.size())
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
        ((LinearLayout)localObject1).setBackgroundResource(h.d.transparent_background);
        ((LinearLayout)localObject1).setOrientation(0);
        ((LinearLayout)localObject1).setLayoutParams(paramView);
        ((LinearLayout)localObject1).setPadding(0, 0, 0, this.vPy);
        localObject2 = new EmojiStoreV2RewardDetailUI.b(EmojiStoreV2RewardDetailUI.this);
        ((EmojiStoreV2RewardDetailUI.b)localObject2).xHe = ((LinearLayout)localObject1);
        ((View)localObject1).setTag(localObject2);
        i = 0;
        for (;;)
        {
          paramViewGroup = (ViewGroup)localObject2;
          paramView = (View)localObject1;
          if (i >= this.mNumColumns) {
            break;
          }
          paramView = new LinearLayout.LayoutParams(this.xVx, this.xVx);
          paramView.leftMargin = this.vPy;
          paramViewGroup = new SquareImageView(this.mContext);
          ((EmojiStoreV2RewardDetailUI.b)localObject2).xHe.addView(paramViewGroup, i, paramView);
          i += 1;
        }
      }
      paramViewGroup = (EmojiStoreV2RewardDetailUI.b)paramView.getTag();
      int i = 0;
      if (i < this.mNumColumns)
      {
        int j = this.mNumColumns;
        localObject1 = (SquareImageView)paramViewGroup.xHe.getChildAt(i);
        localObject2 = Kt(j * paramInt + i);
        if (localObject2 != null)
        {
          ((SquareImageView)localObject1).setVisibility(0);
          if (!Util.isNullOrNil(((cix)localObject2).ZuK)) {
            r.bKe().a(((cix)localObject2).ZuK, (ImageView)localObject1, e.V(EmojiStoreV2RewardDetailUI.c(EmojiStoreV2RewardDetailUI.this), ((cix)localObject2).ZuK, this.xVx));
          }
        }
        for (;;)
        {
          i += 1;
          break;
          ((SquareImageView)localObject1).setImageBitmap(this.hfN);
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
    LinearLayout xHe;
    
    b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2RewardDetailUI
 * JD-Core Version:    0.7.0.1
 */