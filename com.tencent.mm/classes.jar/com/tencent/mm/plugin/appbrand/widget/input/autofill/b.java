package com.tencent.mm.plugin.appbrand.widget.input.autofill;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Filter;
import android.widget.Filter.FilterListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.input.ab;
import com.tencent.mm.plugin.appbrand.widget.input.d.a.b;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;

public final class b
{
  final ab joU;
  public final e joV;
  private final Filter.FilterListener joW;
  public final c joX;
  private final b.a joY;
  private f joZ;
  public a jpa;
  private int jpb;
  private int jpc;
  
  public b(ab paramab)
  {
    AppMethodBeat.i(123890);
    this.joZ = f.jpw;
    this.joU = paramab;
    this.joV = new e(paramab.getContext());
    this.joX = new c(paramab, this.joV);
    this.joU.a(new b.1(this));
    this.joU.a(new b.2(this));
    this.joU.a(new b.3(this));
    this.joU.addTextChangedListener(new TextWatcher()
    {
      private boolean jpe = false;
      
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(123885);
        if ((this.jpe) && (!b.this.joV.aht.isShowing()))
        {
          AppMethodBeat.o(123885);
          return;
        }
        if (!b.this.joV.aht.isShowing()) {
          b.this.aRD();
        }
        b.this.C(paramAnonymousEditable);
        AppMethodBeat.o(123885);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(123884);
        this.jpe = b.this.joV.aht.isShowing();
        AppMethodBeat.o(123884);
      }
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    this.joW = new b.5(this);
    this.joY = new b.6(this);
    AppMethodBeat.o(123890);
  }
  
  final void C(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(123891);
    if (this.jpa == null)
    {
      AppMethodBeat.o(123891);
      return;
    }
    this.jpa.getFilter().filter(paramCharSequence, this.joW);
    AppMethodBeat.o(123891);
  }
  
  final void a(f paramf)
  {
    AppMethodBeat.i(123895);
    if (paramf != null) {
      this.joZ = paramf;
    }
    aRC();
    AppMethodBeat.o(123895);
  }
  
  final void a(h paramh)
  {
    this.joY.jpg = paramh;
  }
  
  final void aRC()
  {
    AppMethodBeat.i(123893);
    switch (b.7.jpf[this.joZ.ordinal()])
    {
    }
    for (;;)
    {
      if (this.jpb != 0)
      {
        this.joV.agY = this.jpb;
        this.joV.aaV -= this.jpb;
      }
      if (this.jpc != 0) {
        this.joV.aaV -= this.jpc;
      }
      AppMethodBeat.o(123893);
      return;
      this.joV.aaV = com.tencent.mm.plugin.appbrand.ui.o.aMu()[0];
      continue;
      this.joV.aaV = this.joU.getView().getMeasuredWidth();
    }
  }
  
  final void aRD()
  {
    AppMethodBeat.i(123896);
    if (this.jpa == null)
    {
      AppMethodBeat.o(123896);
      return;
    }
    Object localObject = this.joU.getText();
    if (!bo.aa((CharSequence)localObject)) {
      C((CharSequence)localObject);
    }
    this.joV.ahj = this.joU.getView();
    this.joV.show();
    ((g)this.joV.jpo.getAdapter()).a(this);
    c localc = this.joX;
    localc.qD(2);
    localc.jpj = -2147483648;
    if (!bo.aa((CharSequence)localObject)) {
      localc.jpk = true;
    }
    localObject = localc.joV.jpo;
    if (localObject != null) {
      ((ListView)localObject).getAdapter().registerDataSetObserver(new c.2(localc));
    }
    AppMethodBeat.o(123896);
  }
  
  final void s(ArrayList<a.b> paramArrayList)
  {
    AppMethodBeat.i(123892);
    this.jpa = new a(this.joU.getContext(), paramArrayList);
    this.jpa.joN = this.joY;
    paramArrayList = this.joV;
    a locala = this.jpa;
    if (paramArrayList.mObserver == null) {
      paramArrayList.mObserver = new AutoFillListPopupWindowBase.c(paramArrayList, (byte)0);
    }
    for (;;)
    {
      paramArrayList.xw = locala;
      if (paramArrayList.xw != null) {
        locala.registerDataSetObserver(paramArrayList.mObserver);
      }
      if (paramArrayList.jpo != null) {
        paramArrayList.jpo.setAdapter(paramArrayList.xw);
      }
      AppMethodBeat.o(123892);
      return;
      if (paramArrayList.xw != null) {
        paramArrayList.xw.unregisterDataSetObserver(paramArrayList.mObserver);
      }
    }
  }
  
  public final void setOnDismissListener(PopupWindow.OnDismissListener paramOnDismissListener)
  {
    AppMethodBeat.i(123894);
    this.joV.setOnDismissListener(paramOnDismissListener);
    AppMethodBeat.o(123894);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.autofill.b
 * JD-Core Version:    0.7.0.1
 */