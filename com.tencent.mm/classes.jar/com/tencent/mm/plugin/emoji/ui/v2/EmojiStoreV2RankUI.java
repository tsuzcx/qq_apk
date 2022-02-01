package com.tencent.mm.plugin.emoji.ui.v2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.z;
import com.tencent.mm.plugin.emoji.a.a.a;
import com.tencent.mm.plugin.emoji.a.a.f.a;
import com.tencent.mm.plugin.emoji.e.k;
import com.tencent.mm.plugin.emoji.f.n;
import com.tencent.mm.plugin.emoji.ui.BaseEmojiStoreUI;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.protobuf.EmotionSummary;
import com.tencent.mm.protocal.protobuf.cna;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import java.io.IOException;

public class EmojiStoreV2RankUI
  extends BaseEmojiStoreUI
{
  protected z pLv;
  private boolean pTO;
  
  public EmojiStoreV2RankUI()
  {
    AppMethodBeat.i(109236);
    this.pLv = new z();
    this.pTO = true;
    AppMethodBeat.o(109236);
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(109239);
    super.a(paramInt1, paramInt2, paramString, paramn);
    if (this.pTO)
    {
      ar.o(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(109235);
          EmojiStoreV2RankUI.a(EmojiStoreV2RankUI.this);
          AppMethodBeat.o(109235);
        }
      }, 300L);
      this.pTO = false;
    }
    AppMethodBeat.o(109239);
  }
  
  public final void a(com.tencent.mm.plugin.emoji.a.a.f paramf, int paramInt)
  {
    AppMethodBeat.i(109240);
    if (paramf == null)
    {
      ae.i("MicroMsg.EmojiStoreV2RankUI", "item is null.");
      AppMethodBeat.o(109240);
      return;
    }
    if (paramf.pIy == f.a.pIH)
    {
      paramf = paramf.pIA;
      if (paramf == null)
      {
        ae.i("MicroMsg.EmojiStoreV2RankUI", "banner set is null. do nothing");
        AppMethodBeat.o(109240);
        return;
      }
      k.a(getContext(), paramf, false);
      AppMethodBeat.o(109240);
      return;
    }
    EmotionSummary localEmotionSummary = paramf.pIz;
    if (localEmotionSummary == null)
    {
      ae.i("MicroMsg.EmojiStoreV2RankUI", "summary is null. do nothing");
      AppMethodBeat.o(109240);
      return;
    }
    this.pLv.hc(String.valueOf(paramInt + 1));
    this.pLv.ha(localEmotionSummary.ProductID);
    this.pLv.hb(localEmotionSummary.Introduce);
    this.pLv.dVT = 3;
    this.pLv.aLH();
    String str = getIntent().getStringExtra("to_talker_name");
    k.a(getContext(), localEmotionSummary, 5, paramf.mStatus, paramf.Hx, str, 105, this.pLv);
    AppMethodBeat.o(109240);
  }
  
  public final int ciJ()
  {
    return 5;
  }
  
  public final int ciK()
  {
    return 105;
  }
  
  public final a ciL()
  {
    AppMethodBeat.i(109241);
    com.tencent.mm.plugin.emoji.a.f localf = new com.tencent.mm.plugin.emoji.a.f(getContext());
    AppMethodBeat.o(109241);
    return localf;
  }
  
  public final int ciS()
  {
    return 10;
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public void initView()
  {
    AppMethodBeat.i(109238);
    super.initView();
    setMMTitle(2131758339);
    this.mListView.setOnScrollListener(new AbsListView.OnScrollListener()
    {
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
      {
        AppMethodBeat.i(109234);
        if (paramAnonymousInt == 0) {
          EmojiStoreV2RankUI.a(EmojiStoreV2RankUI.this);
        }
        AppMethodBeat.o(109234);
      }
    });
    AppMethodBeat.o(109238);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(109237);
    super.onCreate(paramBundle);
    g.yxI.f(12740, new Object[] { Integer.valueOf(4), "", "", "", Integer.valueOf(5), Integer.valueOf(5) });
    this.pLv.dVS = 3;
    this.pNZ.pLv = this.pLv;
    long l = System.currentTimeMillis();
    paramBundle = new cna();
    paramBundle.Hzb = l;
    this.pLv.dVR = l;
    ae.i("MicroMsg.EmojiStoreV2RankUI", "initeData: %s", new Object[] { Long.valueOf(paramBundle.Hzb) });
    try
    {
      this.pNM = paramBundle.toByteArray();
      AppMethodBeat.o(109237);
      return;
    }
    catch (IOException paramBundle)
    {
      ae.printErrStackTrace("MicroMsg.EmojiStoreV2RankUI", paramBundle, "", new Object[0]);
      AppMethodBeat.o(109237);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2RankUI
 * JD-Core Version:    0.7.0.1
 */