package com.tencent.mm.plugin.emoji.ui.v2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.p;
import com.tencent.mm.at.o;
import com.tencent.mm.kernel.b;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.protocal.protobuf.GetEmotionRewardResponse;
import com.tencent.mm.protocal.protobuf.akb;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.emotion.l;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.w;
import com.tencent.mm.ui.widget.MMLoadScrollView.a;

public class EmojiStoreV2RewardDetailUI
  extends MMActivity
  implements AbsListView.OnScrollListener, f
{
  private View Ww;
  private boolean isLoading;
  private String lig;
  private String liv;
  private int ljW;
  private GetEmotionRewardResponse lmz;
  private ak loX;
  private String lpR;
  private String lpS;
  private ImageView lpT;
  private TextView lpU;
  private TextView lpV;
  private TextView lpW;
  private View lpX;
  private View lpY;
  private EmojiStoreV2RewardDetailUI.a lpZ;
  private akb lqa;
  private byte[] lqb;
  private com.tencent.mm.plugin.emoji.f.m lqc;
  private MMLoadScrollView.a lqd;
  private ListView mListView;
  
  public EmojiStoreV2RewardDetailUI()
  {
    AppMethodBeat.i(53678);
    this.isLoading = false;
    this.ljW = -1;
    this.loX = new EmojiStoreV2RewardDetailUI.1(this);
    this.lqd = new EmojiStoreV2RewardDetailUI.2(this);
    AppMethodBeat.o(53678);
  }
  
  private void bnk()
  {
    AppMethodBeat.i(53683);
    this.lqc = new com.tencent.mm.plugin.emoji.f.m(this.lig, this.lqb);
    com.tencent.mm.kernel.g.RK().eHt.a(this.lqc, 0);
    AppMethodBeat.o(53683);
  }
  
  private void gO(boolean paramBoolean)
  {
    AppMethodBeat.i(53684);
    if ((!this.isLoading) && (this.ljW != 0))
    {
      bnk();
      this.isLoading = true;
      if (paramBoolean) {
        this.loX.sendEmptyMessageDelayed(1002, 200L);
      }
    }
    AppMethodBeat.o(53684);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2130969405;
  }
  
  public void initView()
  {
    AppMethodBeat.i(53682);
    setMMTitle(2131299229);
    setBackBtn(new EmojiStoreV2RewardDetailUI.3(this));
    this.Ww = w.hM(getContext()).inflate(2130969406, null);
    this.lpT = ((ImageView)this.Ww.findViewById(2131823654));
    this.lpU = ((TextView)this.Ww.findViewById(2131823687));
    this.lpV = ((TextView)this.Ww.findViewById(2131823659));
    this.lpW = ((TextView)this.Ww.findViewById(2131823688));
    this.lpX = findViewById(2131821003);
    this.mListView = ((ListView)findViewById(2131823685));
    this.lpY = w.hM(getContext()).inflate(2130969387, null);
    this.lpY.setVisibility(8);
    this.mListView.addHeaderView(this.Ww);
    this.mListView.addFooterView(this.lpY);
    this.lpZ = new EmojiStoreV2RewardDetailUI.a(this, this);
    this.mListView.setAdapter(this.lpZ);
    this.mListView.setOnScrollListener(this);
    AppMethodBeat.o(53682);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(53679);
    super.onCreate(paramBundle);
    this.lig = getIntent().getStringExtra("extra_id");
    this.liv = getIntent().getStringExtra("extra_name");
    this.lpR = getIntent().getStringExtra("extra_iconurl");
    this.lpS = getIntent().getStringExtra("name");
    initView();
    this.lmz = i.getEmojiStorageMgr().yNs.asX(this.lig);
    bnk();
    o.ahG().a(this.lpR, this.lpT, com.tencent.mm.plugin.emoji.e.g.dK(this.lig, this.lpR));
    this.lpU.setText(this.liv);
    this.lpV.setText(this.lpS);
    if (this.lqa != null)
    {
      this.lpZ.Q(this.lqa.Donors);
      this.lpZ.lqg = true;
    }
    if (this.lmz != null) {
      this.lpW.setText(getString(2131299230, new Object[] { Integer.valueOf(this.lmz.DonorNum) }));
    }
    com.tencent.mm.kernel.g.RK().eHt.a(299, this);
    AppMethodBeat.o(53679);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(53681);
    super.onDestroy();
    com.tencent.mm.kernel.g.RK().eHt.b(299, this);
    o.ahG().bX(0);
    AppMethodBeat.o(53681);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(53680);
    super.onPause();
    AppMethodBeat.o(53680);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    int i = 1;
    AppMethodBeat.i(53685);
    this.isLoading = false;
    if (this.lpY != null)
    {
      this.lpY.setVisibility(8);
      this.loX.removeMessages(1002);
      this.loX.sendEmptyMessageDelayed(1001, 200L);
    }
    switch (paramm.getType())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(53685);
      return;
      paramString = (com.tencent.mm.plugin.emoji.f.m)paramm;
      if ((paramInt1 == 0) || (paramInt1 == 4))
      {
        this.lqb = paramString.liN;
        if (paramInt2 == 0)
        {
          this.ljW = 0;
          if (paramString.blG() != null)
          {
            this.lpZ.Q(paramString.blG().Donors);
            AppMethodBeat.o(53685);
          }
        }
        else if (paramInt2 == 2)
        {
          this.ljW = 2;
          if (paramString.blG() != null) {
            this.lpZ.Q(paramString.blG().Donors);
          }
          paramInt1 = i;
          if (this.lpZ != null)
          {
            paramInt1 = i;
            if (this.Ww != null)
            {
              paramString = this.lpZ;
              paramInt1 = paramString.loO;
              paramInt2 = paramString.jdO + paramInt1;
              int j = this.Ww.getHeight();
              int k = com.tencent.mm.cb.a.gx(this);
              ab.i("MicroMsg.emoji.EmojiStoreV2RewardDetailUI", "item:%d header:%d window:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(j), Integer.valueOf(k) });
              paramInt1 = i;
              if (k > paramInt2 * this.lpZ.getCount() + j) {
                paramInt1 = 0;
              }
            }
          }
          if (paramInt1 == 0)
          {
            gO(false);
            AppMethodBeat.o(53685);
          }
        }
        else if (paramInt2 == 3)
        {
          this.ljW = 1;
          this.lqb = null;
          this.lpZ.lqg = true;
          gO(false);
          AppMethodBeat.o(53685);
        }
      }
      else
      {
        ab.w("MicroMsg.emoji.EmojiStoreV2RewardDetailUI", "unknow errType:%d", new Object[] { Integer.valueOf(paramInt1) });
      }
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    AppMethodBeat.i(53686);
    if ((paramInt == 0) && (paramAbsListView.getLastVisiblePosition() == paramAbsListView.getCount() - 1))
    {
      if ((this.ljW == 0) || (this.isLoading))
      {
        ab.d("MicroMsg.emoji.EmojiStoreV2RewardDetailUI", "No More List.");
        AppMethodBeat.o(53686);
        return;
      }
      gO(true);
      ab.i("MicroMsg.emoji.EmojiStoreV2RewardDetailUI", "[onScrollStateChanged] loadMoreData.");
      o.ahG().bX(paramInt);
    }
    AppMethodBeat.o(53686);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2RewardDetailUI
 * JD-Core Version:    0.7.0.1
 */