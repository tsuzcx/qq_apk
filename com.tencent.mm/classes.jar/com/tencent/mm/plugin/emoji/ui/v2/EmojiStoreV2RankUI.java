package com.tencent.mm.plugin.emoji.ui.v2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.as;
import com.tencent.mm.plugin.emoji.a.a.a;
import com.tencent.mm.plugin.emoji.a.a.f.a;
import com.tencent.mm.plugin.emoji.e.k;
import com.tencent.mm.plugin.emoji.f.o;
import com.tencent.mm.plugin.emoji.ui.BaseEmojiStoreUI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.EmotionSummary;
import com.tencent.mm.protocal.protobuf.deu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.io.IOException;

public class EmojiStoreV2RankUI
  extends BaseEmojiStoreUI
{
  protected as rbN;
  private boolean rkN;
  
  public EmojiStoreV2RankUI()
  {
    AppMethodBeat.i(109236);
    this.rbN = new as();
    this.rkN = true;
    AppMethodBeat.o(109236);
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, o paramo)
  {
    AppMethodBeat.i(109239);
    super.a(paramInt1, paramInt2, paramString, paramo);
    if (this.rkN)
    {
      MMHandlerThread.postToMainThreadDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(109235);
          EmojiStoreV2RankUI.a(EmojiStoreV2RankUI.this);
          AppMethodBeat.o(109235);
        }
      }, 300L);
      this.rkN = false;
    }
    AppMethodBeat.o(109239);
  }
  
  public final void a(com.tencent.mm.plugin.emoji.a.a.f paramf, int paramInt)
  {
    AppMethodBeat.i(109240);
    if (paramf == null)
    {
      Log.i("MicroMsg.EmojiStoreV2RankUI", "item is null.");
      AppMethodBeat.o(109240);
      return;
    }
    if (paramf.qYk == f.a.qYt)
    {
      paramf = paramf.qYm;
      if (paramf == null)
      {
        Log.i("MicroMsg.EmojiStoreV2RankUI", "banner set is null. do nothing");
        AppMethodBeat.o(109240);
        return;
      }
      k.a(getContext(), paramf, false);
      AppMethodBeat.o(109240);
      return;
    }
    EmotionSummary localEmotionSummary = paramf.qYl;
    if (localEmotionSummary == null)
    {
      Log.i("MicroMsg.EmojiStoreV2RankUI", "summary is null. do nothing");
      AppMethodBeat.o(109240);
      return;
    }
    this.rbN.iz(String.valueOf(paramInt + 1));
    this.rbN.ix(localEmotionSummary.ProductID);
    this.rbN.iy(localEmotionSummary.Introduce);
    this.rbN.eqm = 3;
    this.rbN.bfK();
    String str = getIntent().getStringExtra("to_talker_name");
    k.a(getContext(), localEmotionSummary, 5, paramf.mStatus, paramf.HH, str, 105, this.rbN);
    AppMethodBeat.o(109240);
  }
  
  public final int cGH()
  {
    return 5;
  }
  
  public final int cGI()
  {
    return 105;
  }
  
  public final a cGJ()
  {
    AppMethodBeat.i(109241);
    com.tencent.mm.plugin.emoji.a.f localf = new com.tencent.mm.plugin.emoji.a.f(getContext());
    AppMethodBeat.o(109241);
    return localf;
  }
  
  public final int cGQ()
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
    setMMTitle(2131758633);
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
    h.CyF.a(12740, new Object[] { Integer.valueOf(4), "", "", "", Integer.valueOf(5), Integer.valueOf(5) });
    this.rbN.eql = 3;
    this.rew.rbN = this.rbN;
    long l = System.currentTimeMillis();
    paramBundle = new deu();
    paramBundle.MJN = l;
    this.rbN.eqk = l;
    Log.i("MicroMsg.EmojiStoreV2RankUI", "initeData: %s", new Object[] { Long.valueOf(paramBundle.MJN) });
    try
    {
      this.reh = paramBundle.toByteArray();
      AppMethodBeat.o(109237);
      return;
    }
    catch (IOException paramBundle)
    {
      Log.printErrStackTrace("MicroMsg.EmojiStoreV2RankUI", paramBundle, "", new Object[0]);
      AppMethodBeat.o(109237);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2RankUI
 * JD-Core Version:    0.7.0.1
 */