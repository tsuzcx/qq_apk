package com.tencent.mm.plugin.appbrand.widget.input;

import android.graphics.Rect;
import android.view.View;
import com.tencent.mm.plugin.appbrand.page.q;
import com.tencent.mm.plugin.appbrand.widget.input.d.e;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.ref.WeakReference;
import java.util.Map;

final class d
  extends c<r>
{
  int htd = 0;
  r hte;
  u htf;
  com.tencent.mm.plugin.appbrand.widget.input.d.h htg;
  boolean hth;
  boolean hti;
  
  d(String paramString, q paramq, e parame)
  {
    super(paramString, paramq, parame.hsX);
    this.hte = new r(paramq.mContext);
    this.htd = bk.a((Integer)n.huc.get(paramString), 0);
  }
  
  private u findNumberKeyboard()
  {
    if (this.htf != null) {
      return this.htf;
    }
    u localu = (u)this.hte.getInputPanel();
    this.htf = localu;
    return localu;
  }
  
  private boolean isFocused()
  {
    if (this.hte == null) {}
    do
    {
      return false;
      if (this.hte.isFocused()) {
        return true;
      }
    } while ((findNumberKeyboard() == null) || (!findNumberKeyboard().isShown()) || (this.htf.getAttachedEditText() != this.hte));
    return true;
  }
  
  public final boolean adjustPositionOnFocused()
  {
    return (this.htg != null) && (ai.f(this.htg.hyV));
  }
  
  final Rect arI()
  {
    return new Rect(this.htg.hyB.intValue(), this.htg.hyA.intValue(), this.htg.hyB.intValue() + this.htg.hyy.intValue(), this.htg.hyA.intValue() + this.htg.hyz.intValue());
  }
  
  public final com.tencent.mm.plugin.appbrand.widget.input.d.h b(com.tencent.mm.plugin.appbrand.widget.input.d.h paramh)
  {
    if (this.htg == null)
    {
      this.htg = paramh;
      if ((ai.f(paramh.hzd)) && (this.hte != null)) {
        this.hte.setPasswordMode(true);
      }
    }
    while (this.hte == null)
    {
      return null;
      this.htg.a(paramh);
    }
    b.a(this.hte, this.htg);
    return this.htg;
  }
  
  protected final boolean dT(boolean paramBoolean)
  {
    y.d("MicroMsg.AppBrandInputComponentAsNumber", "[input_switch] onFocusChanged hasFocus %b, isFocused %b", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(isFocused()) });
    if (!paramBoolean) {
      if (!this.hth) {}
    }
    while ((this.hti) || (isFocused()))
    {
      do
      {
        return true;
      } while (!isFocused());
      this.hth = true;
      a(arK());
      hideKeyboard();
      arJ();
      this.hth = false;
      this.hte = null;
      return true;
    }
    this.hti = true;
    showKeyboard(-2, -2);
    this.hti = false;
    return true;
  }
  
  public final View getInputPanel()
  {
    findNumberKeyboard();
    return this.htf;
  }
  
  public final int getInputPanelMarginBottom()
  {
    if ((this.htg == null) || (this.htg.hyS == null)) {
      return 0;
    }
    return this.htg.hyS.intValue();
  }
  
  public final boolean hideKeyboard()
  {
    if (findNumberKeyboard() == null) {}
    while (!isFocused()) {
      return false;
    }
    Object localObject = this.htf;
    ((u)localObject).setVisibility(8);
    ((u)localObject).asa();
    y.d("MicroMsg.AppBrandInputComponentAsNumber", "[input_switch] disableInputFocus %s", new Object[] { this.hte });
    if (this.hte != null)
    {
      this.hte.setFocusable(false);
      this.hte.setFocusableInTouchMode(false);
      this.hte.setEnabled(false);
    }
    localObject = (q)this.hsZ.get();
    if ((localObject != null) && (((q)localObject).gTF != null)) {
      h.arM().g(((q)localObject).gTF);
    }
    j.a(this.hsZ).mN(this.hsX);
    return true;
  }
  
  public final boolean showKeyboard(int paramInt1, int paramInt2)
  {
    if (this.hte == null) {
      return false;
    }
    this.htf = u.cm(((q)this.hsZ.get()).getContentView());
    if (this.htf == null) {
      return false;
    }
    this.hti = true;
    Object localObject = (q)this.hsZ.get();
    if ((localObject != null) && (((q)localObject).gTF != null)) {
      h.arM().f(((q)localObject).gTF);
    }
    this.htf.setXMode(this.htd);
    localObject = this.htf;
    r localr = this.hte;
    if (localr != null)
    {
      if (((u)localObject).ln != localr) {
        ((u)localObject).asa();
      }
      ((u)localObject).setInputEditText(localr);
      ((u)localObject).setVisibility(0);
    }
    this.htf.setOnDoneListener(new u.a()
    {
      public final void onDone()
      {
        d.this.a(d.this.arK());
        d.this.dT(false);
      }
    });
    setInputSelection(paramInt1, paramInt2);
    j.a(this.hsZ).mM(this.hsX);
    this.hti = false;
    return true;
  }
  
  public final boolean xa(String paramString)
  {
    if (this.hte == null) {
      return false;
    }
    this.hte.q(paramString);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.d
 * JD-Core Version:    0.7.0.1
 */