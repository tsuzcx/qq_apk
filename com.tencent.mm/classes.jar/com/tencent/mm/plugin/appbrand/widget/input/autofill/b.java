package com.tencent.mm.plugin.appbrand.widget.input.autofill;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.Filter;
import android.widget.Filter.FilterListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import com.tencent.mm.plugin.appbrand.widget.input.aa;
import com.tencent.mm.sdk.platformtools.bk;

public final class b
{
  final aa hwK;
  public final e hwL;
  private final Filter.FilterListener hwM;
  public final c hwN;
  final b.a hwO;
  f hwP = f.hxm;
  public a hwQ;
  private int hwR;
  private int hwS;
  
  public b(aa paramaa)
  {
    this.hwK = paramaa;
    this.hwL = new e(paramaa.getContext());
    this.hwN = new c(paramaa, this.hwL);
    this.hwK.a(new b.1(this));
    this.hwK.a(new b.2(this));
    this.hwK.a(new View.OnFocusChangeListener()
    {
      public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        if (paramAnonymousBoolean) {
          b.this.asz();
        }
        do
        {
          return;
          paramAnonymousView = b.this;
        } while (!paramAnonymousView.hwL.afe.isShowing());
        g localg = (g)paramAnonymousView.hwL.hxe.getAdapter();
        paramAnonymousView.hwL.dismiss();
        localg.asx();
      }
    });
    this.hwK.addTextChangedListener(new TextWatcher()
    {
      private boolean hwU = false;
      
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        if ((this.hwU) && (!b.this.hwL.afe.isShowing())) {
          return;
        }
        if (!b.this.hwL.afe.isShowing()) {
          b.this.asz();
        }
        b.this.t(paramAnonymousEditable);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        this.hwU = b.this.hwL.afe.isShowing();
      }
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    this.hwM = new b.5(this);
    this.hwO = new b.6(this);
  }
  
  final void asy()
  {
    switch (b.7.hwV[this.hwP.ordinal()])
    {
    }
    for (;;)
    {
      if (this.hwR != 0)
      {
        this.hwL.aeJ = this.hwR;
        this.hwL.aal -= this.hwR;
      }
      if (this.hwS != 0) {
        this.hwL.aal -= this.hwS;
      }
      return;
      this.hwL.aal = com.tencent.mm.plugin.appbrand.ui.l.api()[0];
      continue;
      this.hwL.aal = this.hwK.getView().getMeasuredWidth();
    }
  }
  
  final void asz()
  {
    if (this.hwQ == null) {}
    Object localObject;
    c localc;
    do
    {
      return;
      localObject = this.hwK.getText();
      if (!bk.L((CharSequence)localObject)) {
        t((CharSequence)localObject);
      }
      this.hwL.aeU = this.hwK.getView();
      this.hwL.show();
      ((g)this.hwL.hxe.getAdapter()).a(this);
      localc = this.hwN;
      localc.mZ(2);
      localc.hwZ = -2147483648;
      if (!bk.L((CharSequence)localObject)) {
        localc.hxa = true;
      }
      localObject = localc.hwL.hxe;
    } while (localObject == null);
    ((ListView)localObject).getAdapter().registerDataSetObserver(new c.2(localc));
  }
  
  public final void setOnDismissListener(PopupWindow.OnDismissListener paramOnDismissListener)
  {
    this.hwL.afe.setOnDismissListener(paramOnDismissListener);
  }
  
  final void t(CharSequence paramCharSequence)
  {
    if (this.hwQ == null) {
      return;
    }
    this.hwQ.getFilter().filter(paramCharSequence, this.hwM);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.autofill.b
 * JD-Core Version:    0.7.0.1
 */