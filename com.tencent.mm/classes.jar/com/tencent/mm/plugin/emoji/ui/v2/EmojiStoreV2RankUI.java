package com.tencent.mm.plugin.emoji.ui.v2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.w;
import com.tencent.mm.plugin.emoji.a.a.a;
import com.tencent.mm.plugin.emoji.a.a.f.a;
import com.tencent.mm.plugin.emoji.e.k;
import com.tencent.mm.plugin.emoji.f.n;
import com.tencent.mm.plugin.emoji.ui.BaseEmojiStoreUI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.EmotionSummary;
import com.tencent.mm.protocal.protobuf.chh;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import java.io.IOException;

public class EmojiStoreV2RankUI
  extends BaseEmojiStoreUI
{
  protected w pbh;
  private boolean pjJ;
  
  public EmojiStoreV2RankUI()
  {
    AppMethodBeat.i(109236);
    this.pbh = new w();
    this.pjJ = true;
    AppMethodBeat.o(109236);
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(109239);
    super.a(paramInt1, paramInt2, paramString, paramn);
    if (this.pjJ)
    {
      ap.n(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(109235);
          EmojiStoreV2RankUI.a(EmojiStoreV2RankUI.this);
          AppMethodBeat.o(109235);
        }
      }, 300L);
      this.pjJ = false;
    }
    AppMethodBeat.o(109239);
  }
  
  public final void a(com.tencent.mm.plugin.emoji.a.a.f paramf, int paramInt)
  {
    AppMethodBeat.i(109240);
    if (paramf == null)
    {
      ac.i("MicroMsg.EmojiStoreV2RankUI", "item is null.");
      AppMethodBeat.o(109240);
      return;
    }
    if (paramf.oYk == f.a.oYt)
    {
      paramf = paramf.oYm;
      if (paramf == null)
      {
        ac.i("MicroMsg.EmojiStoreV2RankUI", "banner set is null. do nothing");
        AppMethodBeat.o(109240);
        return;
      }
      k.a(getContext(), paramf, false);
      AppMethodBeat.o(109240);
      return;
    }
    EmotionSummary localEmotionSummary = paramf.oYl;
    if (localEmotionSummary == null)
    {
      ac.i("MicroMsg.EmojiStoreV2RankUI", "summary is null. do nothing");
      AppMethodBeat.o(109240);
      return;
    }
    this.pbh.fU(String.valueOf(paramInt + 1));
    this.pbh.fS(localEmotionSummary.ProductID);
    this.pbh.fT(localEmotionSummary.Introduce);
    this.pbh.dHA = 3;
    this.pbh.aHZ();
    String str = getIntent().getStringExtra("to_talker_name");
    k.a(getContext(), localEmotionSummary, 5, paramf.mStatus, paramf.FG, str, 105, this.pbh);
    AppMethodBeat.o(109240);
  }
  
  public final int ccQ()
  {
    return 5;
  }
  
  public final int ccR()
  {
    return 105;
  }
  
  public final a ccS()
  {
    AppMethodBeat.i(109241);
    com.tencent.mm.plugin.emoji.a.f localf = new com.tencent.mm.plugin.emoji.a.f(getContext());
    AppMethodBeat.o(109241);
    return localf;
  }
  
  public final int ccZ()
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
    h.wUl.f(12740, new Object[] { Integer.valueOf(4), "", "", "", Integer.valueOf(5), Integer.valueOf(5) });
    this.pbh.dHz = 3;
    this.pdT.pbh = this.pbh;
    long l = System.currentTimeMillis();
    paramBundle = new chh();
    paramBundle.Fvw = l;
    this.pbh.dHy = l;
    ac.i("MicroMsg.EmojiStoreV2RankUI", "initeData: %s", new Object[] { Long.valueOf(paramBundle.Fvw) });
    try
    {
      this.pdG = paramBundle.toByteArray();
      AppMethodBeat.o(109237);
      return;
    }
    catch (IOException paramBundle)
    {
      ac.printErrStackTrace("MicroMsg.EmojiStoreV2RankUI", paramBundle, "", new Object[0]);
      AppMethodBeat.o(109237);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2RankUI
 * JD-Core Version:    0.7.0.1
 */