package com.tencent.mm.plugin.choosemsgfile.b.b;

import android.content.Context;
import android.os.Looper;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.ag;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.choosemsgfile.b.d.b;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.widget.MMPinProgressBtn;

public class k
  extends a<n>
{
  private String eaX;
  private j.b kEK;
  public String kET;
  private String kEW;
  private Integer kEX;
  private String kEY;
  private String kEZ;
  
  public k(com.tencent.mm.plugin.choosemsgfile.b.c.g paramg, bi parambi, String paramString)
  {
    super(paramg, parambi);
    this.kET = paramString;
  }
  
  private String Hr()
  {
    AppMethodBeat.i(54318);
    Object localObject;
    if (this.kEZ == null)
    {
      localObject = ((j)com.tencent.mm.kernel.g.E(j.class)).YA().arw(this.kET);
      if (localObject == null) {
        break label59;
      }
    }
    label59:
    for (this.kEZ = ((aq)localObject).field_conRemark;; this.kEZ = "")
    {
      localObject = this.kEZ;
      AppMethodBeat.o(54318);
      return localObject;
    }
  }
  
  private void a(n paramn)
  {
    AppMethodBeat.i(54320);
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      b(paramn);
      AppMethodBeat.o(54320);
      return;
    }
    al.d(new k.1(this, paramn));
    AppMethodBeat.o(54320);
  }
  
  private void b(n paramn)
  {
    AppMethodBeat.i(54321);
    switch (this.kEJ)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(54321);
      return;
      paramn.gvS.setVisibility(0);
      paramn.kFf.setVisibility(8);
      paramn.kFl.setVisibility(8);
      paramn.kFp.setVisibility(8);
      paramn.kFn.setVisibility(8);
      AppMethodBeat.o(54321);
      return;
      paramn.gvS.setVisibility(0);
      paramn.kFf.setVisibility(0);
      paramn.kFl.setVisibility(8);
      paramn.kFp.setVisibility(8);
      paramn.kFn.setVisibility(8);
      if (this.agc > 0)
      {
        int i = (int)(this.Fb / this.agc * 100.0F);
        if ((i == -1) || (i >= 100))
        {
          paramn.kFf.setProgress(100);
          AppMethodBeat.o(54321);
          return;
        }
        paramn.kFf.setProgress(i);
        AppMethodBeat.o(54321);
        return;
        paramn.gvS.setVisibility(8);
        paramn.kFf.setVisibility(8);
        paramn.kFl.setVisibility(0);
        paramn.kFp.setVisibility(0);
        paramn.kFn.setVisibility(8);
        AppMethodBeat.o(54321);
        return;
        paramn.gvS.setVisibility(8);
        paramn.kFf.setVisibility(8);
        paramn.kFl.setVisibility(8);
        paramn.kFp.setVisibility(8);
        paramn.kFn.setVisibility(0);
        paramn.hsI.setText(bgm().toUpperCase() + " " + getContext().getString(2131298358));
        AppMethodBeat.o(54321);
        return;
        paramn.gvS.setVisibility(8);
        paramn.kFf.setVisibility(8);
        paramn.kFl.setVisibility(8);
        paramn.kFp.setVisibility(8);
        paramn.kFn.setVisibility(0);
        paramn.hsI.setText(bgm().toUpperCase() + " " + getContext().getString(2131298357));
        AppMethodBeat.o(54321);
        return;
        paramn.gvS.setVisibility(8);
        paramn.kFf.setVisibility(8);
        paramn.kFl.setVisibility(0);
        paramn.kFp.setVisibility(0);
        paramn.kFl.setChecked(false);
        paramn.kFn.setVisibility(8);
      }
    }
  }
  
  private j.b bgt()
  {
    AppMethodBeat.i(54311);
    if (this.kEK == null) {
      this.kEK = j.b.mY(this.kEz.field_content);
    }
    j.b localb = this.kEK;
    AppMethodBeat.o(54311);
    return localb;
  }
  
  private String bgv()
  {
    AppMethodBeat.i(54317);
    Object localObject;
    if (this.kEY == null)
    {
      localObject = null;
      if (t.lA(this.kET)) {
        localObject = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.chatroom.a.c.class)).YJ().oU(this.kET);
      }
      if (localObject == null) {
        break label75;
      }
    }
    label75:
    for (this.kEY = ((u)localObject).nE(getUsername());; this.kEY = "")
    {
      localObject = this.kEY;
      AppMethodBeat.o(54317);
      return localObject;
    }
  }
  
  public void a(View paramView, a parama)
  {
    AppMethodBeat.i(54319);
    if ((!bgl().im(this.kEz.field_msgId)) && (!jU()))
    {
      if (isEnable())
      {
        b.f(getContext(), this.kEz.field_msgId);
        AppMethodBeat.o(54319);
        return;
      }
      b.J(getContext(), bgl().mMaxCount);
    }
    AppMethodBeat.o(54319);
  }
  
  public String bgm()
  {
    AppMethodBeat.i(54313);
    if (bgt() != null)
    {
      String str = bgt().fgx;
      AppMethodBeat.o(54313);
      return str;
    }
    AppMethodBeat.o(54313);
    return "";
  }
  
  public int bgn()
  {
    AppMethodBeat.i(54316);
    if (bgt() != null)
    {
      int i = bgt().fgw;
      AppMethodBeat.o(54316);
      return i;
    }
    AppMethodBeat.o(54316);
    return 0;
  }
  
  public int bgu()
  {
    AppMethodBeat.i(54314);
    if (this.kEX == null) {
      this.kEX = Integer.valueOf(com.tencent.mm.plugin.fav.ui.c.NV(bgm()));
    }
    int i = this.kEX.intValue();
    AppMethodBeat.o(54314);
    return i;
  }
  
  public String getFileName()
  {
    AppMethodBeat.i(54315);
    if (bgt() != null)
    {
      Object localObject = ((j)com.tencent.mm.kernel.g.E(j.class)).YA().arw(this.kET);
      if (localObject != null) {
        this.kEW = ((ad)localObject).Oe();
      }
      localObject = bgt().title;
      AppMethodBeat.o(54315);
      return localObject;
    }
    AppMethodBeat.o(54315);
    return "";
  }
  
  public int getType()
  {
    return 1;
  }
  
  public String getUsername()
  {
    AppMethodBeat.i(54312);
    if (this.eaX == null) {
      this.eaX = b.b(this.kEz, t.lA(this.kET));
    }
    String str = this.eaX;
    AppMethodBeat.o(54312);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.b.b.k
 * JD-Core Version:    0.7.0.1
 */