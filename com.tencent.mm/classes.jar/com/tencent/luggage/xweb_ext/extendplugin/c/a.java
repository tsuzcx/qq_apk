package com.tencent.luggage.xweb_ext.extendplugin.c;

import android.os.ResultReceiver;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ab;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.page.ar;
import com.tencent.mm.plugin.appbrand.widget.input.d.b;
import com.tencent.mm.plugin.appbrand.widget.input.n;
import com.tencent.mm.plugin.appbrand.widget.input.u;
import com.tencent.mm.plugin.appbrand.widget.input.u.c;
import com.tencent.mm.plugin.appbrand.widget.input.w;
import com.tencent.mm.plugin.appbrand.widget.input.w.c;
import com.tencent.mm.plugin.appbrand.y.g;
import com.tencent.mm.sdk.platformtools.ae;
import org.json.JSONObject;
import org.xwalk.core.XWalkExtendTextAreaClient;
import org.xwalk.core.XWalkView;

public final class a
  extends XWalkExtendTextAreaClient
{
  private final String TAG;
  public ar cwe;
  private u cwf;
  private int cwg;
  private final u.c cwh;
  
  public a(XWalkView paramXWalkView)
  {
    super(paramXWalkView);
    AppMethodBeat.i(139367);
    this.TAG = "WebViewExtendTextAreaClient";
    this.cwg = 0;
    this.cwh = new u.c()
    {
      private final ab coe;
      private int cof;
      
      public final void bu(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(139364);
        Object localObject = a.b(a.this).bvB();
        c localc = a.b(a.this).bcc();
        if (localObject != null)
        {
          ab localab = this.coe;
          if (paramAnonymousBoolean)
          {
            i = this.cof;
            d.g.b.p.h(localc, "service");
            d.g.b.p.h(localObject, "page");
            localab.p("height", Integer.valueOf(g.vM(i)));
            localab.g(localc).bja();
            localab.g((c)localObject).bja();
          }
        }
        else
        {
          localObject = a.a(a.this);
          if (localObject != null)
          {
            if (!paramAnonymousBoolean) {
              break label152;
            }
            i = this.cof;
            label115:
            ((w)localObject).gB(i);
          }
          localObject = a.this;
          if (!paramAnonymousBoolean) {
            break label157;
          }
        }
        label152:
        label157:
        for (int i = this.cof;; i = 0)
        {
          ((a)localObject).onKeyboardHeightChanged(paramAnonymousBoolean, i, false);
          AppMethodBeat.o(139364);
          return;
          i = 0;
          break;
          i = 0;
          break label115;
        }
      }
      
      public final void gB(int paramAnonymousInt)
      {
        AppMethodBeat.i(139363);
        this.cof = paramAnonymousInt;
        w localw = a.a(a.this);
        if (localw != null) {
          localw.gB(paramAnonymousInt);
        }
        AppMethodBeat.o(139363);
      }
      
      public final int getHeight()
      {
        return this.cof;
      }
    };
    AppMethodBeat.o(139367);
  }
  
  private w GU()
  {
    AppMethodBeat.i(139368);
    if ((this.cwe != null) && (this.cwe.bvB() != null))
    {
      w localw = w.dl(this.cwe.bvB().getContentView());
      AppMethodBeat.o(139368);
      return localw;
    }
    AppMethodBeat.o(139368);
    return null;
  }
  
  private void GV()
  {
    AppMethodBeat.i(220546);
    getXWalkView().evaluateJavascript("(function(){var focusElement = document.activeElement;if(focusElement){if(focusElement.onkeyboardconfirm){focusElement.onkeyboardconfirm();}focusElement.blur();}})();", new ValueCallback() {});
    AppMethodBeat.o(220546);
  }
  
  public final int getToolBarHeight(int paramInt)
  {
    AppMethodBeat.i(139371);
    w localw = GU();
    if (localw != null)
    {
      int i = localw.getMinimumHeight();
      AppMethodBeat.o(139371);
      return paramInt + i;
    }
    AppMethodBeat.o(139371);
    return paramInt;
  }
  
  public final boolean onHideKeyboard(String paramString, InputConnection paramInputConnection)
  {
    AppMethodBeat.i(139370);
    if (this.cwe != null)
    {
      paramString = GU();
      if (paramString != null) {
        paramString.bu(false);
      }
    }
    if (this.cwf != null) {
      this.cwf.b(this.cwh);
    }
    AppMethodBeat.o(139370);
    return false;
  }
  
  public final boolean onShowKeyboard(String paramString, InputConnection paramInputConnection, ResultReceiver paramResultReceiver)
  {
    AppMethodBeat.i(139369);
    if (this.cwf == null) {
      this.cwf = n.df(this.cwe.bvB().getContentView());
    }
    if (this.cwf != null) {
      this.cwf.a(this.cwh);
    }
    paramString = new a.a(this, paramString);
    if (this.cwe != null)
    {
      paramInputConnection = GU();
      if (paramInputConnection != null) {
        if (paramString.cwn) {
          if ((paramString.cwo) || (!"emoji".equals(paramString.cwl))) {
            break label145;
          }
        }
      }
    }
    label145:
    for (boolean bool = true;; bool = false)
    {
      paramInputConnection.setCanSmileyInput(bool);
      paramInputConnection.setShowDoneButton(paramString.cwn);
      paramInputConnection.setOnDoneListener(new w.c()
      {
        public final void bM(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(139365);
          a.c(a.this);
          AppMethodBeat.o(139365);
        }
      });
      paramInputConnection.bu(paramString.cwn);
      AppMethodBeat.o(139369);
      return false;
    }
  }
  
  public final boolean onShowKeyboardConfig(int paramInt1, int paramInt2, String paramString, int paramInt3, int paramInt4, EditorInfo paramEditorInfo)
  {
    Object localObject = null;
    AppMethodBeat.i(220544);
    ae.d("WebViewExtendTextAreaClient", "onShowKeyboardConfig");
    try
    {
      paramString = b.We(new JSONObject(paramString).optString("confirm-type", null));
      if (paramString != null)
      {
        ae.i("WebViewExtendTextAreaClient", "onShowKeyboardConfig, confirmType: ".concat(String.valueOf(paramString)));
        if (b.nnT != paramString) {
          paramEditorInfo.imeOptions &= 0xBFFFFFFF;
        }
        paramEditorInfo.imeOptions |= paramString.nnU;
        this.cwg = paramString.nnU;
      }
      AppMethodBeat.o(220544);
      return false;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        ae.w("WebViewExtendTextAreaClient", "onShowKeyboardConfig, get confirm-type error");
        paramString = localObject;
      }
    }
  }
  
  public final boolean performEditorAction(int paramInt)
  {
    AppMethodBeat.i(220545);
    ae.d("WebViewExtendTextAreaClient", "performEditorAction, actionCode: ".concat(String.valueOf(paramInt)));
    switch (paramInt)
    {
    case 6: 
    default: 
      if ((paramInt != 0) && (paramInt == this.cwg))
      {
        ae.i("WebViewExtendTextAreaClient", "performEditorAction, doOnKeyboardConfirmLogic");
        GV();
        AppMethodBeat.o(220545);
        return false;
      }
      break;
    case 5: 
    case 7: 
      AppMethodBeat.o(220545);
      return true;
    }
    AppMethodBeat.o(220545);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.c.a
 * JD-Core Version:    0.7.0.1
 */