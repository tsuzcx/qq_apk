package com.tencent.mm.plugin.choosemsgfile.logic.b;

import android.content.Context;
import android.os.Looper;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.kernel.h;
import com.tencent.mm.message.k.b;
import com.tencent.mm.model.ar;
import com.tencent.mm.plugin.chatroom.a.b;
import com.tencent.mm.plugin.choosemsgfile.a.h;
import com.tencent.mm.plugin.choosemsgfile.logic.c.c;
import com.tencent.mm.plugin.choosemsgfile.logic.ui.g;
import com.tencent.mm.plugin.fav.ui.e;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.widget.MMPinProgressBtn;

public class k
  extends a<n>
{
  private String luk;
  private k.b wPJ;
  public String wPO;
  private String wPR;
  private Integer wPS;
  private String wPT;
  private String wPU;
  
  public k(g paramg, cc paramcc, String paramString)
  {
    super(paramg, paramcc);
    this.wPO = paramString;
  }
  
  private void a(final n paramn)
  {
    AppMethodBeat.i(123292);
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      b(paramn);
      AppMethodBeat.o(123292);
      return;
    }
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(123282);
        k.a(k.this, paramn);
        AppMethodBeat.o(123282);
      }
    });
    AppMethodBeat.o(123292);
  }
  
  private void b(n paramn)
  {
    AppMethodBeat.i(123293);
    switch (this.wPI)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(123293);
      return;
      paramn.pRi.setVisibility(0);
      paramn.wQa.setVisibility(8);
      paramn.lDE.setVisibility(8);
      paramn.wQj.setVisibility(8);
      paramn.wQh.setVisibility(8);
      AppMethodBeat.o(123293);
      return;
      paramn.pRi.setVisibility(0);
      paramn.wQa.setVisibility(0);
      paramn.lDE.setVisibility(8);
      paramn.wQj.setVisibility(8);
      paramn.wQh.setVisibility(8);
      if (this.tK > 0)
      {
        int i = (int)(this.Sc / this.tK * 100.0F);
        if ((i == -1) || (i >= 100))
        {
          paramn.wQa.setProgress(100);
          AppMethodBeat.o(123293);
          return;
        }
        paramn.wQa.setProgress(i);
        AppMethodBeat.o(123293);
        return;
        paramn.pRi.setVisibility(8);
        paramn.wQa.setVisibility(8);
        paramn.lDE.setVisibility(0);
        paramn.wQj.setVisibility(0);
        paramn.wQh.setVisibility(8);
        AppMethodBeat.o(123293);
        return;
        paramn.pRi.setVisibility(8);
        paramn.wQa.setVisibility(8);
        paramn.lDE.setVisibility(8);
        paramn.wQj.setVisibility(8);
        paramn.wQh.setVisibility(0);
        paramn.descTv.setText(getFileExt().toUpperCase() + " " + getContext().getString(a.h.choose_msg_file_fail_expire));
        AppMethodBeat.o(123293);
        return;
        paramn.pRi.setVisibility(8);
        paramn.wQa.setVisibility(8);
        paramn.lDE.setVisibility(8);
        paramn.wQj.setVisibility(8);
        paramn.wQh.setVisibility(0);
        paramn.descTv.setText(getFileExt().toUpperCase() + " " + getContext().getString(a.h.choose_msg_file_fail_download));
        AppMethodBeat.o(123293);
        return;
        paramn.pRi.setVisibility(8);
        paramn.wQa.setVisibility(8);
        paramn.lDE.setVisibility(0);
        paramn.wQj.setVisibility(0);
        paramn.lDE.setChecked(false);
        paramn.wQh.setVisibility(8);
      }
    }
  }
  
  private String dqB()
  {
    AppMethodBeat.i(123289);
    Object localObject;
    if (this.wPT == null)
    {
      localObject = null;
      if (au.bwE(this.wPO)) {
        localObject = ((b)h.ax(b.class)).bzK().Ju(this.wPO);
      }
      if (localObject == null) {
        break label75;
      }
    }
    label75:
    for (this.wPT = ((aj)localObject).getDisplayName(getUsername());; this.wPT = "")
    {
      localObject = this.wPT;
      AppMethodBeat.o(123289);
      return localObject;
    }
  }
  
  private String dqC()
  {
    AppMethodBeat.i(123290);
    Object localObject;
    if (this.wPU == null)
    {
      localObject = ((com.tencent.mm.plugin.messenger.foundation.a.n)h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE(this.wPO);
      if (localObject == null) {
        break label59;
      }
    }
    label59:
    for (this.wPU = ((az)localObject).field_conRemark;; this.wPU = "")
    {
      localObject = this.wPU;
      AppMethodBeat.o(123290);
      return localObject;
    }
  }
  
  private k.b dqz()
  {
    AppMethodBeat.i(123283);
    if (this.wPJ == null) {
      this.wPJ = k.b.Hf(this.wPy.field_content);
    }
    k.b localb = this.wPJ;
    AppMethodBeat.o(123283);
    return localb;
  }
  
  public void a(View paramView, a parama)
  {
    AppMethodBeat.i(123291);
    if ((!dqs().kC(this.wPy.field_msgId)) && (!isInvalid()))
    {
      if (isEnable())
      {
        c.g(getContext(), this.wPy.field_msgId);
        AppMethodBeat.o(123291);
        return;
      }
      c.ah(getContext(), dqs().sfk);
    }
    AppMethodBeat.o(123291);
  }
  
  public int dqA()
  {
    AppMethodBeat.i(123286);
    if (this.wPS == null) {
      this.wPS = Integer.valueOf(e.aut(getFileExt()));
    }
    int i = this.wPS.intValue();
    AppMethodBeat.o(123286);
    return i;
  }
  
  public int dqt()
  {
    AppMethodBeat.i(123288);
    if (dqz() != null)
    {
      int i = dqz().nRd;
      AppMethodBeat.o(123288);
      return i;
    }
    AppMethodBeat.o(123288);
    return 0;
  }
  
  public String getFileExt()
  {
    AppMethodBeat.i(123285);
    if (dqz() != null)
    {
      String str = dqz().nRe;
      AppMethodBeat.o(123285);
      return str;
    }
    AppMethodBeat.o(123285);
    return "";
  }
  
  public String getFileName()
  {
    AppMethodBeat.i(123287);
    if (dqz() != null)
    {
      Object localObject = ((com.tencent.mm.plugin.messenger.foundation.a.n)h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE(this.wPO);
      if (localObject != null) {
        this.wPR = ((au)localObject).aSU();
      }
      localObject = dqz().title;
      AppMethodBeat.o(123287);
      return localObject;
    }
    AppMethodBeat.o(123287);
    return "";
  }
  
  public int getType()
  {
    return 1;
  }
  
  public String getUsername()
  {
    AppMethodBeat.i(123284);
    if (this.luk == null) {
      this.luk = c.b(this.wPy, au.bwE(this.wPO));
    }
    String str = this.luk;
    AppMethodBeat.o(123284);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.logic.b.k
 * JD-Core Version:    0.7.0.1
 */