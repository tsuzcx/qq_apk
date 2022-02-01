package com.tencent.luggage.xweb_ext.extendplugin.c;

import android.os.ResultReceiver;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.webkit.ValueCallback;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.g;
import com.tencent.mm.plugin.appbrand.jsapi.af;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.jsapi.s;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.page.au;
import com.tencent.mm.plugin.appbrand.widget.input.d.b;
import com.tencent.mm.plugin.appbrand.widget.input.n;
import com.tencent.mm.plugin.appbrand.widget.input.u;
import com.tencent.mm.plugin.appbrand.widget.input.u.c;
import com.tencent.mm.plugin.appbrand.widget.input.w;
import com.tencent.mm.plugin.appbrand.widget.input.w.c;
import com.tencent.mm.plugin.appbrand.widget.input.w.d;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import org.json.JSONObject;
import org.xwalk.core.XWalkExtendTextAreaClient;
import org.xwalk.core.XWalkView;

public final class a
  extends XWalkExtendTextAreaClient
{
  private final String TAG;
  public au cKd;
  private u cKe;
  private w cKf;
  private EditText cKg;
  private int cKh;
  private int cKi;
  private boolean cKj;
  private final u.c cKk;
  
  public a(XWalkView paramXWalkView)
  {
    super(paramXWalkView);
    AppMethodBeat.i(139367);
    this.TAG = "WebViewExtendTextAreaClient";
    this.cKh = 0;
    this.cKi = 0;
    this.cKj = false;
    this.cKk = new u.c()
    {
      private final af cAj;
      private int crC;
      
      public final void bQ(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(215754);
        Object localObject = a.e(a.this).bRH();
        f localf = a.e(a.this).bxr();
        if (localObject != null)
        {
          af localaf = this.cAj;
          if (paramAnonymousBoolean)
          {
            i = a.this.getToolBarHeight(this.crC);
            p.h(localf, "service");
            p.h(localObject, "page");
            localaf.p("height", Integer.valueOf(g.zB(i)));
            localaf.g(localf).bEo();
            localaf.g((f)localObject).bEo();
          }
        }
        else
        {
          localObject = a.d(a.this);
          if (localObject != null)
          {
            if (a.c(a.this) != null)
            {
              if (!paramAnonymousBoolean) {
                break label184;
              }
              ((w)localObject).oum = a.c(a.this);
            }
            label138:
            if (!paramAnonymousBoolean) {
              break label199;
            }
            i = this.crC;
            label147:
            ((w)localObject).hF(i);
          }
          localObject = a.this;
          if (!paramAnonymousBoolean) {
            break label204;
          }
        }
        label184:
        label199:
        label204:
        for (int i = this.crC;; i = 0)
        {
          ((a)localObject).onKeyboardHeightChanged(paramAnonymousBoolean, i, false);
          AppMethodBeat.o(215754);
          return;
          i = 0;
          break;
          ((w)localObject).b(a.c(a.this));
          break label138;
          i = 0;
          break label147;
        }
      }
      
      public final int getHeight()
      {
        return this.crC;
      }
      
      public final void hF(int paramAnonymousInt)
      {
        AppMethodBeat.i(215753);
        this.crC = paramAnonymousInt;
        w localw = a.d(a.this);
        if (localw != null) {
          localw.hF(paramAnonymousInt);
        }
        AppMethodBeat.o(215753);
      }
    };
    AppMethodBeat.o(139367);
  }
  
  private w QN()
  {
    Object localObject2 = null;
    AppMethodBeat.i(139368);
    Object localObject1;
    if (this.cKf != null)
    {
      localObject1 = this.cKf;
      AppMethodBeat.o(139368);
      return localObject1;
    }
    if ((this.cKd != null) && (this.cKd.bRH() != null))
    {
      View localView = this.cKd.bRH().getContentView();
      localObject1 = localObject2;
      if (this.cKd.bRH() != null)
      {
        localObject1 = localObject2;
        if ((this.cKd.bRH() instanceof ac)) {
          localObject1 = ((ac)this.cKd.bRH()).bRo();
        }
      }
      this.cKf = w.b(localView, (com.tencent.mm.plugin.appbrand.n.a)localObject1);
      if (this.cKf != null)
      {
        this.cKg = new EditText(this.cKf.getContext());
        this.cKf.a(new w.d()
        {
          public final EditText getEditText()
          {
            AppMethodBeat.i(215751);
            EditText localEditText = a.c(a.this);
            AppMethodBeat.o(215751);
            return localEditText;
          }
          
          public final void ig(int paramAnonymousInt)
          {
            boolean bool = true;
            AppMethodBeat.i(215750);
            int i = a.a(a.this).getMinimumHeight();
            int j = paramAnonymousInt - i;
            Log.i("WebViewExtendTextAreaClient", "OnHeightChangedListener, totalHeight: %d, lateSavedKeyboardPanelHeight: %d, currentKeyboardPanelHeight: %d", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(a.b(a.this)), Integer.valueOf(i) });
            a locala;
            if (a.b(a.this) != i)
            {
              a.a(a.this, i);
              locala = a.this;
              if (j <= 0) {
                break label106;
              }
            }
            for (;;)
            {
              locala.onKeyboardHeightChanged(bool, j, false);
              AppMethodBeat.o(215750);
              return;
              label106:
              bool = false;
            }
          }
        });
      }
      localObject1 = this.cKf;
      AppMethodBeat.o(139368);
      return localObject1;
    }
    AppMethodBeat.o(139368);
    return null;
  }
  
  private void cl(boolean paramBoolean)
  {
    AppMethodBeat.i(215758);
    StringBuilder localStringBuilder = new StringBuilder("(function(){    var focusElement = document.activeElement;    if(focusElement){        if(focusElement.onkeyboardconfirm){            focusElement.onkeyboardconfirm();        }");
    if (!paramBoolean) {}
    for (String str = "        focusElement.blur();";; str = "")
    {
      str = str + "    }})();";
      getXWalkView().evaluateJavascript(str, new ValueCallback() {});
      AppMethodBeat.o(215758);
      return;
    }
  }
  
  public final int getToolBarHeight(int paramInt)
  {
    AppMethodBeat.i(139371);
    w localw = QN();
    if (localw != null)
    {
      this.cKh = localw.getMinimumHeight();
      int i = this.cKh;
      AppMethodBeat.o(139371);
      return paramInt + i;
    }
    AppMethodBeat.o(139371);
    return paramInt;
  }
  
  public final boolean onHideKeyboard(String paramString, InputConnection paramInputConnection)
  {
    AppMethodBeat.i(139370);
    if (this.cKd != null)
    {
      paramString = QN();
      if (paramString != null) {
        paramString.bQ(false);
      }
    }
    if (this.cKe != null) {
      this.cKe.b(this.cKk);
    }
    AppMethodBeat.o(139370);
    return false;
  }
  
  public final boolean onShowKeyboard(String paramString, InputConnection paramInputConnection, ResultReceiver paramResultReceiver)
  {
    AppMethodBeat.i(139369);
    if (this.cKe == null) {
      this.cKe = n.cY(this.cKd.bRH().getContentView());
    }
    if (this.cKe != null) {
      this.cKe.a(this.cKk);
    }
    paramString = new a(paramString);
    this.cKj = paramString.cKt;
    if (this.cKd != null)
    {
      paramInputConnection = QN();
      if (paramInputConnection != null) {
        if (paramString.cKq)
        {
          paramInputConnection.setComponentView(paramString.cKs);
          paramInputConnection.cbN();
          if ((paramString.cKr) || (!"emoji".equals(paramString.cKo))) {
            break label165;
          }
        }
      }
    }
    label165:
    for (boolean bool = true;; bool = false)
    {
      paramInputConnection.setCanSmileyInput(bool);
      paramInputConnection.setShowDoneButton(paramString.cKq);
      paramInputConnection.setOnDoneListener(new w.c()
      {
        public final void cm(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(215755);
          Log.i("WebViewExtendTextAreaClient", "onInputDone#onShowKeyboard, fromDoneButton: %b, confirmHold: %b", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Boolean.valueOf(a.f(a.this)) });
          a.g(a.this);
          AppMethodBeat.o(215755);
        }
      });
      paramInputConnection.bQ(paramString.cKq);
      AppMethodBeat.o(139369);
      return false;
    }
  }
  
  public final boolean onShowKeyboardConfig(int paramInt1, int paramInt2, String paramString, int paramInt3, int paramInt4, EditorInfo paramEditorInfo)
  {
    Object localObject = null;
    AppMethodBeat.i(215756);
    Log.d("WebViewExtendTextAreaClient", "onShowKeyboardConfig");
    try
    {
      paramString = b.aga(new JSONObject(paramString).optString("confirm-type", null));
      if (paramString != null)
      {
        Log.i("WebViewExtendTextAreaClient", "onShowKeyboardConfig, confirmType: ".concat(String.valueOf(paramString)));
        if (b.oxz != paramString) {
          paramEditorInfo.imeOptions &= 0xBFFFFFFF;
        }
        paramEditorInfo.imeOptions |= paramString.oxA;
        this.cKi = paramString.oxA;
      }
      AppMethodBeat.o(215756);
      return false;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Log.w("WebViewExtendTextAreaClient", "onShowKeyboardConfig, get confirm-type error");
        paramString = localObject;
      }
    }
  }
  
  public final boolean performEditorAction(int paramInt)
  {
    AppMethodBeat.i(215757);
    Log.d("WebViewExtendTextAreaClient", "performEditorAction, actionCode: ".concat(String.valueOf(paramInt)));
    if ((paramInt != 0) && (paramInt == this.cKi))
    {
      Log.i("WebViewExtendTextAreaClient", "performEditorAction, confirmHold: " + this.cKj);
      cl(this.cKj);
      AppMethodBeat.o(215757);
      return false;
    }
    AppMethodBeat.o(215757);
    return true;
  }
  
  public final class a
  {
    public String cKm;
    public String cKn;
    public String cKo;
    public Integer cKp;
    public boolean cKq;
    public boolean cKr;
    public boolean cKs;
    public boolean cKt;
    
    /* Error */
    public a(String paramString)
    {
      // Byte code:
      //   0: aload_0
      //   1: aload_1
      //   2: putfield 30	com/tencent/luggage/xweb_ext/extendplugin/c/a$a:cKl	Lcom/tencent/luggage/xweb_ext/extendplugin/c/a;
      //   5: aload_0
      //   6: invokespecial 33	java/lang/Object:<init>	()V
      //   9: ldc 34
      //   11: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   14: aload_0
      //   15: ldc 42
      //   17: putfield 44	com/tencent/luggage/xweb_ext/extendplugin/c/a$a:cKm	Ljava/lang/String;
      //   20: aload_0
      //   21: ldc 42
      //   23: putfield 46	com/tencent/luggage/xweb_ext/extendplugin/c/a$a:cKn	Ljava/lang/String;
      //   26: aload_0
      //   27: ldc 42
      //   29: putfield 48	com/tencent/luggage/xweb_ext/extendplugin/c/a$a:cKo	Ljava/lang/String;
      //   32: aload_0
      //   33: aconst_null
      //   34: putfield 50	com/tencent/luggage/xweb_ext/extendplugin/c/a$a:cKp	Ljava/lang/Integer;
      //   37: aload_0
      //   38: iconst_0
      //   39: putfield 52	com/tencent/luggage/xweb_ext/extendplugin/c/a$a:cKq	Z
      //   42: aload_0
      //   43: iconst_0
      //   44: putfield 54	com/tencent/luggage/xweb_ext/extendplugin/c/a$a:cKr	Z
      //   47: aload_0
      //   48: iconst_0
      //   49: putfield 56	com/tencent/luggage/xweb_ext/extendplugin/c/a$a:cKs	Z
      //   52: aload_0
      //   53: iconst_0
      //   54: putfield 58	com/tencent/luggage/xweb_ext/extendplugin/c/a$a:cKt	Z
      //   57: ldc 60
      //   59: ldc 62
      //   61: aload_2
      //   62: invokestatic 68	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
      //   65: invokevirtual 72	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
      //   68: invokestatic 77	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   71: aload_0
      //   72: aload_2
      //   73: putfield 44	com/tencent/luggage/xweb_ext/extendplugin/c/a$a:cKm	Ljava/lang/String;
      //   76: new 79	org/json/JSONObject
      //   79: dup
      //   80: aload_2
      //   81: invokespecial 82	org/json/JSONObject:<init>	(Ljava/lang/String;)V
      //   84: astore_1
      //   85: aload_1
      //   86: ldc 84
      //   88: invokevirtual 88	org/json/JSONObject:has	(Ljava/lang/String;)Z
      //   91: ifeq +13 -> 104
      //   94: aload_0
      //   95: aload_1
      //   96: ldc 84
      //   98: invokevirtual 91	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
      //   101: putfield 46	com/tencent/luggage/xweb_ext/extendplugin/c/a$a:cKn	Ljava/lang/String;
      //   104: aload_1
      //   105: ldc 93
      //   107: invokevirtual 88	org/json/JSONObject:has	(Ljava/lang/String;)Z
      //   110: ifeq +13 -> 123
      //   113: aload_0
      //   114: aload_1
      //   115: ldc 93
      //   117: invokevirtual 91	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
      //   120: putfield 48	com/tencent/luggage/xweb_ext/extendplugin/c/a$a:cKo	Ljava/lang/String;
      //   123: aload_1
      //   124: ldc 95
      //   126: invokevirtual 88	org/json/JSONObject:has	(Ljava/lang/String;)Z
      //   129: ifeq +20 -> 149
      //   132: aload_0
      //   133: aload_1
      //   134: ldc 95
      //   136: invokevirtual 91	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
      //   139: iconst_0
      //   140: invokestatic 101	com/tencent/mm/sdk/platformtools/Util:getInt	(Ljava/lang/String;I)I
      //   143: invokestatic 106	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   146: putfield 50	com/tencent/luggage/xweb_ext/extendplugin/c/a$a:cKp	Ljava/lang/Integer;
      //   149: aload_1
      //   150: ldc 108
      //   152: invokevirtual 88	org/json/JSONObject:has	(Ljava/lang/String;)Z
      //   155: ifeq +17 -> 172
      //   158: aload_0
      //   159: aload_1
      //   160: ldc 108
      //   162: invokevirtual 91	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
      //   165: iconst_0
      //   166: invokestatic 112	com/tencent/mm/sdk/platformtools/Util:getBoolean	(Ljava/lang/String;Z)Z
      //   169: putfield 52	com/tencent/luggage/xweb_ext/extendplugin/c/a$a:cKq	Z
      //   172: aload_1
      //   173: ldc 114
      //   175: invokevirtual 88	org/json/JSONObject:has	(Ljava/lang/String;)Z
      //   178: ifeq +17 -> 195
      //   181: aload_0
      //   182: aload_1
      //   183: ldc 114
      //   185: invokevirtual 91	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
      //   188: iconst_0
      //   189: invokestatic 112	com/tencent/mm/sdk/platformtools/Util:getBoolean	(Ljava/lang/String;Z)Z
      //   192: putfield 54	com/tencent/luggage/xweb_ext/extendplugin/c/a$a:cKr	Z
      //   195: aload_1
      //   196: ldc 116
      //   198: invokevirtual 88	org/json/JSONObject:has	(Ljava/lang/String;)Z
      //   201: ifeq +17 -> 218
      //   204: aload_0
      //   205: aload_1
      //   206: ldc 116
      //   208: invokevirtual 91	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
      //   211: iconst_0
      //   212: invokestatic 112	com/tencent/mm/sdk/platformtools/Util:getBoolean	(Ljava/lang/String;Z)Z
      //   215: putfield 56	com/tencent/luggage/xweb_ext/extendplugin/c/a$a:cKs	Z
      //   218: aload_1
      //   219: ldc 118
      //   221: invokevirtual 88	org/json/JSONObject:has	(Ljava/lang/String;)Z
      //   224: ifeq +17 -> 241
      //   227: aload_0
      //   228: aload_1
      //   229: ldc 118
      //   231: invokevirtual 91	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
      //   234: iconst_0
      //   235: invokestatic 112	com/tencent/mm/sdk/platformtools/Util:getBoolean	(Ljava/lang/String;Z)Z
      //   238: putfield 58	com/tencent/luggage/xweb_ext/extendplugin/c/a$a:cKt	Z
      //   241: ldc 34
      //   243: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   246: return
      //   247: astore_1
      //   248: ldc 60
      //   250: ldc 123
      //   252: invokestatic 126	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   255: new 79	org/json/JSONObject
      //   258: dup
      //   259: invokespecial 127	org/json/JSONObject:<init>	()V
      //   262: astore_1
      //   263: goto -178 -> 85
      //   266: astore_2
      //   267: ldc 60
      //   269: ldc 129
      //   271: invokestatic 126	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   274: goto -170 -> 104
      //   277: astore_2
      //   278: ldc 60
      //   280: ldc 131
      //   282: invokestatic 126	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   285: goto -162 -> 123
      //   288: astore_2
      //   289: ldc 60
      //   291: ldc 133
      //   293: invokestatic 126	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   296: goto -147 -> 149
      //   299: astore_2
      //   300: ldc 60
      //   302: ldc 135
      //   304: invokestatic 126	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   307: goto -158 -> 149
      //   310: astore_2
      //   311: ldc 60
      //   313: ldc 135
      //   315: invokestatic 126	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   318: goto -169 -> 149
      //   321: astore_2
      //   322: ldc 60
      //   324: ldc 137
      //   326: invokestatic 126	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   329: goto -157 -> 172
      //   332: astore_2
      //   333: ldc 60
      //   335: ldc 137
      //   337: invokestatic 126	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   340: goto -168 -> 172
      //   343: astore_2
      //   344: ldc 60
      //   346: ldc 139
      //   348: invokestatic 126	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   351: goto -156 -> 195
      //   354: astore_2
      //   355: ldc 60
      //   357: ldc 139
      //   359: invokestatic 126	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   362: goto -167 -> 195
      //   365: astore_2
      //   366: ldc 60
      //   368: ldc 141
      //   370: invokestatic 126	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   373: goto -155 -> 218
      //   376: astore_2
      //   377: ldc 60
      //   379: ldc 141
      //   381: invokestatic 126	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   384: goto -166 -> 218
      //   387: astore_1
      //   388: ldc 60
      //   390: ldc 143
      //   392: invokestatic 126	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   395: ldc 34
      //   397: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   400: return
      //   401: astore_1
      //   402: ldc 60
      //   404: ldc 143
      //   406: invokestatic 126	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   409: ldc 34
      //   411: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   414: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	415	0	this	a
      //   0	415	1	this$1	a
      //   0	415	2	paramString	String
      // Exception table:
      //   from	to	target	type
      //   76	85	247	java/lang/Exception
      //   85	104	266	org/json/JSONException
      //   104	123	277	org/json/JSONException
      //   123	149	288	org/json/JSONException
      //   123	149	299	java/lang/NumberFormatException
      //   123	149	310	java/lang/Exception
      //   149	172	321	org/json/JSONException
      //   149	172	332	java/lang/Exception
      //   172	195	343	org/json/JSONException
      //   172	195	354	java/lang/Exception
      //   195	218	365	org/json/JSONException
      //   195	218	376	java/lang/Exception
      //   218	241	387	org/json/JSONException
      //   218	241	401	java/lang/Exception
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.c.a
 * JD-Core Version:    0.7.0.1
 */