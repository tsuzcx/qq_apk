package com.tencent.luggage.xweb_ext.extendplugin.c;

import android.os.ResultReceiver;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ab;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.page.as;
import com.tencent.mm.plugin.appbrand.widget.input.d.b;
import com.tencent.mm.plugin.appbrand.widget.input.n;
import com.tencent.mm.plugin.appbrand.widget.input.u;
import com.tencent.mm.plugin.appbrand.widget.input.u.c;
import com.tencent.mm.plugin.appbrand.widget.input.w;
import com.tencent.mm.plugin.appbrand.widget.input.w.c;
import com.tencent.mm.plugin.appbrand.z.g;
import com.tencent.mm.sdk.platformtools.ad;
import org.json.JSONObject;
import org.xwalk.core.XWalkExtendTextAreaClient;
import org.xwalk.core.XWalkView;

public final class a
  extends XWalkExtendTextAreaClient
{
  private final String TAG;
  public as cvA;
  private u cvB;
  private int cvC;
  private final u.c cvD;
  
  public a(XWalkView paramXWalkView)
  {
    super(paramXWalkView);
    AppMethodBeat.i(139367);
    this.TAG = "WebViewExtendTextAreaClient";
    this.cvC = 0;
    this.cvD = new u.c()
    {
      private final ab coc;
      private int cod;
      
      public final void bu(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(139364);
        Object localObject = a.b(a.this).buP();
        c localc = a.b(a.this).buQ();
        if (localObject != null)
        {
          ab localab = this.coc;
          if (paramAnonymousBoolean)
          {
            i = this.cod;
            d.g.b.p.h(localc, "service");
            d.g.b.p.h(localObject, "page");
            localab.p("height", Integer.valueOf(g.vH(i)));
            localab.g(localc).bir();
            localab.g((c)localObject).bir();
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
            i = this.cod;
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
        for (int i = this.cod;; i = 0)
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
        this.cod = paramAnonymousInt;
        w localw = a.a(a.this);
        if (localw != null) {
          localw.gB(paramAnonymousInt);
        }
        AppMethodBeat.o(139363);
      }
      
      public final int getHeight()
      {
        return this.cod;
      }
    };
    AppMethodBeat.o(139367);
  }
  
  private w GO()
  {
    AppMethodBeat.i(139368);
    if ((this.cvA != null) && (this.cvA.buP() != null))
    {
      w localw = w.dl(this.cvA.buP().getContentView());
      AppMethodBeat.o(139368);
      return localw;
    }
    AppMethodBeat.o(139368);
    return null;
  }
  
  private void GP()
  {
    AppMethodBeat.i(186854);
    getXWalkView().evaluateJavascript("(function(){var focusElement = document.activeElement;if(focusElement){if(focusElement.onkeyboardconfirm){focusElement.onkeyboardconfirm();}focusElement.blur();}})();", new ValueCallback() {});
    AppMethodBeat.o(186854);
  }
  
  public final int getToolBarHeight(int paramInt)
  {
    AppMethodBeat.i(139371);
    w localw = GO();
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
    if (this.cvA != null)
    {
      paramString = GO();
      if (paramString != null) {
        paramString.bu(false);
      }
    }
    if (this.cvB != null) {
      this.cvB.b(this.cvD);
    }
    AppMethodBeat.o(139370);
    return false;
  }
  
  public final boolean onShowKeyboard(String paramString, InputConnection paramInputConnection, ResultReceiver paramResultReceiver)
  {
    AppMethodBeat.i(139369);
    if (this.cvB == null) {
      this.cvB = n.df(this.cvA.buP().getContentView());
    }
    if (this.cvB != null) {
      this.cvB.a(this.cvD);
    }
    paramString = new a.a(this, paramString);
    if (this.cvA != null)
    {
      paramInputConnection = GO();
      if (paramInputConnection != null) {
        if (paramString.cvJ) {
          if ((paramString.cvK) || (!"emoji".equals(paramString.cvH))) {
            break label145;
          }
        }
      }
    }
    label145:
    for (boolean bool = true;; bool = false)
    {
      paramInputConnection.setCanSmileyInput(bool);
      paramInputConnection.setShowDoneButton(paramString.cvJ);
      paramInputConnection.setOnDoneListener(new w.c()
      {
        public final void bM(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(139365);
          a.c(a.this);
          AppMethodBeat.o(139365);
        }
      });
      paramInputConnection.bu(paramString.cvJ);
      AppMethodBeat.o(139369);
      return false;
    }
  }
  
  public final boolean onShowKeyboardConfig(int paramInt1, int paramInt2, String paramString, int paramInt3, int paramInt4, EditorInfo paramEditorInfo)
  {
    Object localObject = null;
    AppMethodBeat.i(186852);
    ad.d("WebViewExtendTextAreaClient", "onShowKeyboardConfig");
    try
    {
      paramString = b.Vs(new JSONObject(paramString).optString("confirm-type", null));
      if (paramString != null)
      {
        ad.i("WebViewExtendTextAreaClient", "onShowKeyboardConfig, confirmType: ".concat(String.valueOf(paramString)));
        if (b.niL != paramString) {
          paramEditorInfo.imeOptions &= 0xBFFFFFFF;
        }
        paramEditorInfo.imeOptions |= paramString.niM;
        this.cvC = paramString.niM;
      }
      AppMethodBeat.o(186852);
      return false;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        ad.w("WebViewExtendTextAreaClient", "onShowKeyboardConfig, get confirm-type error");
        paramString = localObject;
      }
    }
  }
  
  public final boolean performEditorAction(int paramInt)
  {
    AppMethodBeat.i(186853);
    ad.d("WebViewExtendTextAreaClient", "performEditorAction, actionCode: ".concat(String.valueOf(paramInt)));
    switch (paramInt)
    {
    case 6: 
    default: 
      if ((paramInt != 0) && (paramInt == this.cvC))
      {
        ad.i("WebViewExtendTextAreaClient", "performEditorAction, doOnKeyboardConfirmLogic");
        GP();
        AppMethodBeat.o(186853);
        return false;
      }
      break;
    case 5: 
    case 7: 
      AppMethodBeat.o(186853);
      return true;
    }
    AppMethodBeat.o(186853);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.c.a
 * JD-Core Version:    0.7.0.1
 */