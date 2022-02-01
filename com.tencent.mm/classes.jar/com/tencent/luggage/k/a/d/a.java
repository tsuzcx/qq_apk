package com.tencent.luggage.k.a.d;

import android.os.ResultReceiver;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.aa.g;
import com.tencent.mm.plugin.appbrand.jsapi.ab;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.page.ax;
import com.tencent.mm.plugin.appbrand.widget.input.n;
import com.tencent.mm.plugin.appbrand.widget.input.u;
import com.tencent.mm.plugin.appbrand.widget.input.u.c;
import com.tencent.mm.plugin.appbrand.widget.input.w;
import com.tencent.mm.plugin.appbrand.widget.input.w.c;
import d.g.b.k;
import org.xwalk.core.XWalkExtendTextAreaClient;
import org.xwalk.core.XWalkView;

public final class a
  extends XWalkExtendTextAreaClient
{
  private final String TAG;
  public ax cnW;
  private u cnX;
  private final u.c cnY;
  
  public a(XWalkView paramXWalkView)
  {
    super(paramXWalkView);
    AppMethodBeat.i(139367);
    this.TAG = "WebViewExtendTextAreaClient";
    this.cnY = new u.c()
    {
      private final ab cgQ;
      private int cgR;
      
      public final void bu(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(139364);
        Object localObject = a.b(a.this).bjY();
        c localc = a.b(a.this).bjZ();
        if (localObject != null)
        {
          ab localab = this.cgQ;
          if (paramAnonymousBoolean)
          {
            i = this.cgR;
            k.h(localc, "service");
            k.h(localObject, "page");
            localab.r("height", Integer.valueOf(g.uk(i)));
            localab.g(localc).aXQ();
            localab.g((c)localObject).aXQ();
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
            i = this.cgR;
            label115:
            ((w)localObject).gM(i);
          }
          localObject = a.this;
          if (!paramAnonymousBoolean) {
            break label157;
          }
        }
        label152:
        label157:
        for (int i = this.cgR;; i = 0)
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
      
      public final void gM(int paramAnonymousInt)
      {
        AppMethodBeat.i(139363);
        this.cgR = paramAnonymousInt;
        w localw = a.a(a.this);
        if (localw != null) {
          localw.gM(paramAnonymousInt);
        }
        AppMethodBeat.o(139363);
      }
      
      public final int getHeight()
      {
        return this.cgR;
      }
    };
    AppMethodBeat.o(139367);
  }
  
  private w FM()
  {
    AppMethodBeat.i(139368);
    if ((this.cnW != null) && (this.cnW.bjY() != null))
    {
      w localw = w.dh(this.cnW.bjY().getContentView());
      AppMethodBeat.o(139368);
      return localw;
    }
    AppMethodBeat.o(139368);
    return null;
  }
  
  public final int getToolBarHeight(int paramInt)
  {
    AppMethodBeat.i(139371);
    w localw = FM();
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
    if (this.cnW != null)
    {
      paramString = FM();
      if (paramString != null) {
        paramString.bu(false);
      }
    }
    if (this.cnX != null) {
      this.cnX.b(this.cnY);
    }
    AppMethodBeat.o(139370);
    return false;
  }
  
  public final boolean onShowKeyboard(String paramString, InputConnection paramInputConnection, ResultReceiver paramResultReceiver)
  {
    AppMethodBeat.i(139369);
    if (this.cnX == null) {
      this.cnX = n.db(this.cnW.bjY().getContentView());
    }
    if (this.cnX != null) {
      this.cnX.a(this.cnY);
    }
    paramString = new a.a(this, paramString);
    if (this.cnW != null)
    {
      paramInputConnection = FM();
      if (paramInputConnection != null) {
        if (paramString.cof) {
          if ((paramString.cog) || (!"emoji".equals(paramString.cod))) {
            break label145;
          }
        }
      }
    }
    label145:
    for (boolean bool = true;; bool = false)
    {
      paramInputConnection.setCanSmileyInput(bool);
      paramInputConnection.setShowDoneButton(paramString.cof);
      paramInputConnection.setOnDoneListener(new w.c()
      {
        public final void bM(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(139365);
          a.this.getXWalkView().evaluateJavascript("(function(){var focusElement = document.activeElement;if(focusElement){if(focusElement.onkeyboardconfirm){focusElement.onkeyboardconfirm();}focusElement.blur();}})();", new ValueCallback() {});
          AppMethodBeat.o(139365);
        }
      });
      paramInputConnection.bu(paramString.cof);
      AppMethodBeat.o(139369);
      return false;
    }
  }
  
  public final boolean onShowKeyboardConfig(int paramInt1, int paramInt2, String paramString, int paramInt3, int paramInt4, EditorInfo paramEditorInfo)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.k.a.d.a
 * JD-Core Version:    0.7.0.1
 */