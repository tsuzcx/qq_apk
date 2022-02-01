package com.tencent.mm.plugin.choosemsgfile.b.b;

import android.content.Context;
import android.os.Looper;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ap;
import com.tencent.mm.plugin.fav.ui.e;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.widget.MMPinProgressBtn;

public class k
  extends a<n>
{
  private String goe;
  private k.b qnG;
  public String qnQ;
  private String qnT;
  private Integer qnU;
  private String qnV;
  private String qnW;
  
  public k(com.tencent.mm.plugin.choosemsgfile.b.c.g paramg, ca paramca, String paramString)
  {
    super(paramg, paramca);
    this.qnQ = paramString;
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
  
  private String ajy()
  {
    AppMethodBeat.i(123290);
    Object localObject;
    if (this.qnW == null)
    {
      localObject = ((l)com.tencent.mm.kernel.g.af(l.class)).aSN().Kn(this.qnQ);
      if (localObject == null) {
        break label59;
      }
    }
    label59:
    for (this.qnW = ((ax)localObject).field_conRemark;; this.qnW = "")
    {
      localObject = this.qnW;
      AppMethodBeat.o(123290);
      return localObject;
    }
  }
  
  private void b(n paramn)
  {
    AppMethodBeat.i(123293);
    switch (this.qnF)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(123293);
      return;
      paramn.kdb.setVisibility(0);
      paramn.qoc.setVisibility(8);
      paramn.gxr.setVisibility(8);
      paramn.qol.setVisibility(8);
      paramn.qoj.setVisibility(8);
      AppMethodBeat.o(123293);
      return;
      paramn.kdb.setVisibility(0);
      paramn.qoc.setVisibility(0);
      paramn.gxr.setVisibility(8);
      paramn.qol.setVisibility(8);
      paramn.qoj.setVisibility(8);
      if (this.aqi > 0)
      {
        int i = (int)(this.fs / this.aqi * 100.0F);
        if ((i == -1) || (i >= 100))
        {
          paramn.qoc.setProgress(100);
          AppMethodBeat.o(123293);
          return;
        }
        paramn.qoc.setProgress(i);
        AppMethodBeat.o(123293);
        return;
        paramn.kdb.setVisibility(8);
        paramn.qoc.setVisibility(8);
        paramn.gxr.setVisibility(0);
        paramn.qol.setVisibility(0);
        paramn.qoj.setVisibility(8);
        AppMethodBeat.o(123293);
        return;
        paramn.kdb.setVisibility(8);
        paramn.qoc.setVisibility(8);
        paramn.gxr.setVisibility(8);
        paramn.qol.setVisibility(8);
        paramn.qoj.setVisibility(0);
        paramn.hPW.setText(getFileExt().toUpperCase() + " " + getContext().getString(2131757568));
        AppMethodBeat.o(123293);
        return;
        paramn.kdb.setVisibility(8);
        paramn.qoc.setVisibility(8);
        paramn.gxr.setVisibility(8);
        paramn.qol.setVisibility(8);
        paramn.qoj.setVisibility(0);
        paramn.hPW.setText(getFileExt().toUpperCase() + " " + getContext().getString(2131757567));
        AppMethodBeat.o(123293);
        return;
        paramn.kdb.setVisibility(8);
        paramn.qoc.setVisibility(8);
        paramn.gxr.setVisibility(0);
        paramn.qol.setVisibility(0);
        paramn.gxr.setChecked(false);
        paramn.qoj.setVisibility(8);
      }
    }
  }
  
  private String cyB()
  {
    AppMethodBeat.i(123289);
    Object localObject;
    if (this.qnV == null)
    {
      localObject = null;
      if (ab.Eq(this.qnQ)) {
        localObject = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX().Kd(this.qnQ);
      }
      if (localObject == null) {
        break label75;
      }
    }
    label75:
    for (this.qnV = ((ah)localObject).getDisplayName(getUsername());; this.qnV = "")
    {
      localObject = this.qnV;
      AppMethodBeat.o(123289);
      return localObject;
    }
  }
  
  private k.b cyz()
  {
    AppMethodBeat.i(123283);
    if (this.qnG == null) {
      this.qnG = k.b.HD(this.qnv.field_content);
    }
    k.b localb = this.qnG;
    AppMethodBeat.o(123283);
    return localb;
  }
  
  public void a(View paramView, a parama)
  {
    AppMethodBeat.i(123291);
    if ((!cys().Cb(this.qnv.field_msgId)) && (!isInvalid()))
    {
      if (isEnable())
      {
        com.tencent.mm.plugin.choosemsgfile.b.d.c.g(getContext(), this.qnv.field_msgId);
        AppMethodBeat.o(123291);
        return;
      }
      com.tencent.mm.plugin.choosemsgfile.b.d.c.V(getContext(), cys().mMaxCount);
    }
    AppMethodBeat.o(123291);
  }
  
  public int cyA()
  {
    AppMethodBeat.i(123286);
    if (this.qnU == null) {
      this.qnU = Integer.valueOf(e.asl(getFileExt()));
    }
    int i = this.qnU.intValue();
    AppMethodBeat.o(123286);
    return i;
  }
  
  public int cyt()
  {
    AppMethodBeat.i(123288);
    if (cyz() != null)
    {
      int i = cyz().iwI;
      AppMethodBeat.o(123288);
      return i;
    }
    AppMethodBeat.o(123288);
    return 0;
  }
  
  public String getFileExt()
  {
    AppMethodBeat.i(123285);
    if (cyz() != null)
    {
      String str = cyz().iwJ;
      AppMethodBeat.o(123285);
      return str;
    }
    AppMethodBeat.o(123285);
    return "";
  }
  
  public String getFileName()
  {
    AppMethodBeat.i(123287);
    if (cyz() != null)
    {
      Object localObject = ((l)com.tencent.mm.kernel.g.af(l.class)).aSN().Kn(this.qnQ);
      if (localObject != null) {
        this.qnT = ((as)localObject).arI();
      }
      localObject = cyz().title;
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
    if (this.goe == null) {
      this.goe = com.tencent.mm.plugin.choosemsgfile.b.d.c.b(this.qnv, ab.Eq(this.qnQ));
    }
    String str = this.goe;
    AppMethodBeat.o(123284);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.b.b.k
 * JD-Core Version:    0.7.0.1
 */