package com.tencent.mm.plugin.choosemsgfile.b.b;

import android.content.Context;
import android.os.Looper;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.f.c.et;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.aq;
import com.tencent.mm.plugin.chatroom.a.b;
import com.tencent.mm.plugin.choosemsgfile.a.h;
import com.tencent.mm.plugin.choosemsgfile.b.c.g;
import com.tencent.mm.plugin.choosemsgfile.b.d.c;
import com.tencent.mm.plugin.fav.ui.e;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.widget.MMPinProgressBtn;

public class k
  extends a<n>
{
  private String iSn;
  private String tMB;
  private Integer tMC;
  private String tMD;
  private String tME;
  private k.b tMt;
  public String tMy;
  
  public k(g paramg, ca paramca, String paramString)
  {
    super(paramg, paramca);
    this.tMy = paramString;
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
  
  private String apg()
  {
    AppMethodBeat.i(123290);
    Object localObject;
    if (this.tME == null)
    {
      localObject = ((com.tencent.mm.plugin.messenger.foundation.a.n)h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbL().RG(this.tMy);
      if (localObject == null) {
        break label59;
      }
    }
    label59:
    for (this.tME = ((ax)localObject).field_conRemark;; this.tME = "")
    {
      localObject = this.tME;
      AppMethodBeat.o(123290);
      return localObject;
    }
  }
  
  private void b(n paramn)
  {
    AppMethodBeat.i(123293);
    switch (this.tMs)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(123293);
      return;
      paramn.mUB.setVisibility(0);
      paramn.tMK.setVisibility(8);
      paramn.jbE.setVisibility(8);
      paramn.tMT.setVisibility(8);
      paramn.tMR.setVisibility(8);
      AppMethodBeat.o(123293);
      return;
      paramn.mUB.setVisibility(0);
      paramn.tMK.setVisibility(0);
      paramn.jbE.setVisibility(8);
      paramn.tMT.setVisibility(8);
      paramn.tMR.setVisibility(8);
      if (this.sL > 0)
      {
        int i = (int)(this.zP / this.sL * 100.0F);
        if ((i == -1) || (i >= 100))
        {
          paramn.tMK.setProgress(100);
          AppMethodBeat.o(123293);
          return;
        }
        paramn.tMK.setProgress(i);
        AppMethodBeat.o(123293);
        return;
        paramn.mUB.setVisibility(8);
        paramn.tMK.setVisibility(8);
        paramn.jbE.setVisibility(0);
        paramn.tMT.setVisibility(0);
        paramn.tMR.setVisibility(8);
        AppMethodBeat.o(123293);
        return;
        paramn.mUB.setVisibility(8);
        paramn.tMK.setVisibility(8);
        paramn.jbE.setVisibility(8);
        paramn.tMT.setVisibility(8);
        paramn.tMR.setVisibility(0);
        paramn.kEs.setText(getFileExt().toUpperCase() + " " + getContext().getString(a.h.choose_msg_file_fail_expire));
        AppMethodBeat.o(123293);
        return;
        paramn.mUB.setVisibility(8);
        paramn.tMK.setVisibility(8);
        paramn.jbE.setVisibility(8);
        paramn.tMT.setVisibility(8);
        paramn.tMR.setVisibility(0);
        paramn.kEs.setText(getFileExt().toUpperCase() + " " + getContext().getString(a.h.choose_msg_file_fail_download));
        AppMethodBeat.o(123293);
        return;
        paramn.mUB.setVisibility(8);
        paramn.tMK.setVisibility(8);
        paramn.jbE.setVisibility(0);
        paramn.tMT.setVisibility(0);
        paramn.jbE.setChecked(false);
        paramn.tMR.setVisibility(8);
      }
    }
  }
  
  private k.b cMU()
  {
    AppMethodBeat.i(123283);
    if (this.tMt == null) {
      this.tMt = k.b.OQ(this.tMi.field_content);
    }
    k.b localb = this.tMt;
    AppMethodBeat.o(123283);
    return localb;
  }
  
  private String cMW()
  {
    AppMethodBeat.i(123289);
    Object localObject;
    if (this.tMD == null)
    {
      localObject = null;
      if (ab.Lj(this.tMy)) {
        localObject = ((b)h.ae(b.class)).bbV().Rw(this.tMy);
      }
      if (localObject == null) {
        break label75;
      }
    }
    label75:
    for (this.tMD = ((ah)localObject).PJ(getUsername());; this.tMD = "")
    {
      localObject = this.tMD;
      AppMethodBeat.o(123289);
      return localObject;
    }
  }
  
  public void a(View paramView, a parama)
  {
    AppMethodBeat.i(123291);
    if ((!cMN().Ik(this.tMi.field_msgId)) && (!isInvalid()))
    {
      if (isEnable())
      {
        c.g(getContext(), this.tMi.field_msgId);
        AppMethodBeat.o(123291);
        return;
      }
      c.aa(getContext(), cMN().mMaxCount);
    }
    AppMethodBeat.o(123291);
  }
  
  public int cMO()
  {
    AppMethodBeat.i(123288);
    if (cMU() != null)
    {
      int i = cMU().llX;
      AppMethodBeat.o(123288);
      return i;
    }
    AppMethodBeat.o(123288);
    return 0;
  }
  
  public int cMV()
  {
    AppMethodBeat.i(123286);
    if (this.tMC == null) {
      this.tMC = Integer.valueOf(e.aAm(getFileExt()));
    }
    int i = this.tMC.intValue();
    AppMethodBeat.o(123286);
    return i;
  }
  
  public String getFileExt()
  {
    AppMethodBeat.i(123285);
    if (cMU() != null)
    {
      String str = cMU().llY;
      AppMethodBeat.o(123285);
      return str;
    }
    AppMethodBeat.o(123285);
    return "";
  }
  
  public String getFileName()
  {
    AppMethodBeat.i(123287);
    if (cMU() != null)
    {
      Object localObject = ((com.tencent.mm.plugin.messenger.foundation.a.n)h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbL().RG(this.tMy);
      if (localObject != null) {
        this.tMB = ((as)localObject).ayr();
      }
      localObject = cMU().title;
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
    if (this.iSn == null) {
      this.iSn = c.b(this.tMi, ab.Lj(this.tMy));
    }
    String str = this.iSn;
    AppMethodBeat.o(123284);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.b.b.k
 * JD-Core Version:    0.7.0.1
 */