package com.tencent.mm.modelvoiceaddr.ui;

import android.app.Activity;
import android.view.KeyEvent;
import android.view.Menu;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelvoiceaddr.f;
import com.tencent.mm.modelvoiceaddr.f.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.ui.tools.q;

public final class b
  extends q
{
  public boolean gcJ;
  public int gcK;
  public int gcL;
  b.a gcM;
  public VoiceSearchLayout gcN;
  private VoiceSearchLayout.a gcO;
  
  public b()
  {
    AppMethodBeat.i(116788);
    this.gcJ = true;
    this.gcO = new b.1(this);
    AppMethodBeat.o(116788);
  }
  
  public b(byte paramByte)
  {
    super((byte)0);
    AppMethodBeat.i(116789);
    this.gcJ = true;
    this.gcO = new b.1(this);
    AppMethodBeat.o(116789);
  }
  
  public final void a(Activity paramActivity, Menu paramMenu)
  {
    AppMethodBeat.i(116793);
    super.a(paramActivity, paramMenu);
    if (this.gcN != null) {
      this.gcN.setOnSearchListener(this.gcO);
    }
    AppMethodBeat.o(116793);
  }
  
  public final void a(b.a parama)
  {
    this.gcM = parama;
    this.Axg = parama;
  }
  
  public final boolean amZ()
  {
    boolean bool1 = false;
    AppMethodBeat.i(116791);
    boolean bool2 = this.gcJ;
    if (this.gcN == null) {
      bool1 = true;
    }
    ab.d("MicroMsg.VoiceSearchViewHelper", "check has voice search, Enable %B, layout is null ? %B", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
    bool1 = this.gcJ;
    AppMethodBeat.o(116791);
    return bool1;
  }
  
  public final void ana()
  {
    AppMethodBeat.i(116792);
    ab.d("MicroMsg.VoiceSearchViewHelper", "do require voice search");
    if (this.Axf != null)
    {
      this.Axf.setEditTextEnabled(false);
      this.Axf.setStatusBtnEnabled(false);
    }
    if ((this.gcN != null) && (this.gcN.getVisibility() == 8))
    {
      ab.d("MicroMsg.VoiceSearchViewHelper", "do voice search layout start");
      Object localObject = this.gcN;
      int i = this.gcL;
      boolean bool = com.tencent.mm.pluginsdk.permission.b.o(((VoiceSearchLayout)localObject).getContext(), "android.permission.RECORD_AUDIO");
      ab.i("MicroMsg.VoiceSearchLayout", "summerper checkPermission checkMicrophone[%b]", new Object[] { Boolean.valueOf(bool) });
      if (bool)
      {
        ab.d("MicroMsg.VoiceSearchLayout", "doStart " + ((VoiceSearchLayout)localObject).isStart);
        ((VoiceSearchLayout)localObject).gcu = i;
        ((VoiceSearchLayout)localObject).isStart = true;
        ((VoiceSearchLayout)localObject).gct = false;
        if (((VoiceSearchLayout)localObject).gcr != null) {
          ((VoiceSearchLayout)localObject).gcr.amX();
        }
        ((VoiceSearchLayout)localObject).setVisibility(0);
        ((VoiceSearchLayout)localObject).gcG.ag(50L, 50L);
        ((VoiceSearchLayout)localObject).jdMethod_do(true);
        ((VoiceSearchLayout)localObject).gcF = 0;
        ((VoiceSearchLayout)localObject).gcy = new f(new VoiceSearchLayout.4((VoiceSearchLayout)localObject), i);
        localObject = ((VoiceSearchLayout)localObject).gcy;
        ab.i("MicroMsg.SceneVoiceAddr", "start record");
        if ((((f)localObject).gbj == 0) && (at.is2G(ah.getContext()))) {}
        for (bool = true;; bool = false)
        {
          ((f)localObject).gbu = bool;
          ab.i("MicroMsg.SceneVoiceAddr", "mEnableAmrMode: %b", new Object[] { Boolean.valueOf(((f)localObject).gbu) });
          com.tencent.mm.sdk.g.d.post(new f.a((f)localObject), "SceneVoiceAddr_record");
          AppMethodBeat.o(116792);
          return;
        }
      }
      if ((((VoiceSearchLayout)localObject).getContext() instanceof Activity)) {
        com.tencent.mm.pluginsdk.permission.b.b((Activity)((VoiceSearchLayout)localObject).getContext(), "android.permission.RECORD_AUDIO", 80);
      }
      AppMethodBeat.o(116792);
      return;
    }
    AppMethodBeat.o(116792);
  }
  
  public final void anb()
  {
    AppMethodBeat.i(116795);
    cancel();
    AppMethodBeat.o(116795);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(116790);
    ab.d("MicroMsg.VoiceSearchViewHelper", "do cancel");
    if (this.gcN != null) {
      this.gcN.amT();
    }
    if (this.Axf != null)
    {
      this.Axf.setEditTextEnabled(true);
      this.Axf.setStatusBtnEnabled(true);
    }
    AppMethodBeat.o(116790);
  }
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(116794);
    if (4 == paramInt)
    {
      if ((this.gcN != null) && (this.gcN.getVisibility() == 0)) {}
      for (bool = true;; bool = false)
      {
        ab.d("MicroMsg.VoiceSearchViewHelper", "on back key down, try hide voice search panel, it is visiable[%B]", new Object[] { Boolean.valueOf(bool) });
        cancel();
        if (!bool) {
          break;
        }
        AppMethodBeat.o(116794);
        return true;
      }
    }
    ab.d("MicroMsg.VoiceSearchViewHelper", "not match key code, pass to super");
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(116794);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.modelvoiceaddr.ui.b
 * JD-Core Version:    0.7.0.1
 */