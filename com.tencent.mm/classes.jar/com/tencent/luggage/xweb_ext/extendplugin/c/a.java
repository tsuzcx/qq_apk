package com.tencent.luggage.xweb_ext.extendplugin.c;

import android.os.ResultReceiver;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.webkit.ValueCallback;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.af;
import com.tencent.mm.plugin.appbrand.jsapi.g;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.page.aw;
import com.tencent.mm.plugin.appbrand.widget.input.aa;
import com.tencent.mm.plugin.appbrand.widget.input.aa.c;
import com.tencent.mm.plugin.appbrand.widget.input.aa.d;
import com.tencent.mm.plugin.appbrand.widget.input.e.b;
import com.tencent.mm.plugin.appbrand.widget.input.n;
import com.tencent.mm.plugin.appbrand.widget.input.u;
import com.tencent.mm.plugin.appbrand.widget.input.u.c;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;
import org.xwalk.core.XWalkExtendTextAreaClient;
import org.xwalk.core.XWalkView;

public final class a
  extends XWalkExtendTextAreaClient
{
  private final String TAG;
  public aw cKG;
  private u cKH;
  private aa cKI;
  private EditText cKJ;
  private int cKK;
  private int cKL;
  private boolean cKM;
  private aa.d cKN;
  private final u.c cKO;
  private int cpD;
  private final af czp;
  private boolean czr;
  
  public a(XWalkView paramXWalkView)
  {
    super(paramXWalkView);
    AppMethodBeat.i(139367);
    this.TAG = "WebViewExtendTextAreaClient";
    this.cKK = 0;
    this.cpD = 0;
    this.czr = false;
    this.cKL = 0;
    this.cKM = false;
    this.czp = new af();
    this.cKN = new aa.d()
    {
      public final EditText getEditText()
      {
        AppMethodBeat.i(222403);
        EditText localEditText = a.d(a.this);
        AppMethodBeat.o(222403);
        return localEditText;
      }
      
      public final void jj(int paramAnonymousInt)
      {
        boolean bool = true;
        AppMethodBeat.i(222402);
        if (a.a(a.this) == null)
        {
          AppMethodBeat.o(222402);
          return;
        }
        int i = a.a(a.this).getMinimumHeight();
        int j = paramAnonymousInt - i;
        Log.i("WebViewExtendTextAreaClient", "OnHeightChangedListener, totalHeight: %d, lateSavedKeyboardPanelHeight: %d, currentKeyboardPanelHeight: %d", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(a.b(a.this)), Integer.valueOf(i) });
        a locala;
        if (a.b(a.this) != i)
        {
          a.a(a.this, i);
          locala = a.this;
          if (j <= 0) {
            break label129;
          }
        }
        for (;;)
        {
          locala.onKeyboardHeightChanged(bool, j, false);
          a.c(a.this);
          AppMethodBeat.o(222402);
          return;
          label129:
          bool = false;
        }
      }
    };
    this.cKO = new u.c()
    {
      public final void ca(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(223057);
        Object localObject = a.f(a.this);
        if (localObject != null)
        {
          if (a.d(a.this) != null)
          {
            if (paramAnonymousBoolean) {
              ((aa)localObject).rwP = a.d(a.this);
            }
          }
          else
          {
            if (!paramAnonymousBoolean) {
              break label111;
            }
            i = a.e(a.this);
            label54:
            ((aa)localObject).iF(i);
          }
        }
        else
        {
          localObject = a.this;
          if (!paramAnonymousBoolean) {
            break label116;
          }
        }
        label111:
        label116:
        for (int i = a.e(a.this);; i = 0)
        {
          ((a)localObject).onKeyboardHeightChanged(paramAnonymousBoolean, i, false);
          a.c(a.this);
          AppMethodBeat.o(223057);
          return;
          ((aa)localObject).b(a.d(a.this));
          break;
          i = 0;
          break label54;
        }
      }
      
      public final int getHeight()
      {
        AppMethodBeat.i(223059);
        int i = a.e(a.this);
        AppMethodBeat.o(223059);
        return i;
      }
      
      public final void iF(int paramAnonymousInt)
      {
        int j = 0;
        AppMethodBeat.i(223051);
        int i = j;
        Object localObject;
        if (paramAnonymousInt != 0)
        {
          i = j;
          if (a.e(a.this) != 0)
          {
            i = j;
            if (paramAnonymousInt != a.e(a.this))
            {
              localObject = a.this;
              if (paramAnonymousInt <= 0) {
                break label108;
              }
            }
          }
        }
        label108:
        for (boolean bool = true;; bool = false)
        {
          ((a)localObject).onKeyboardHeightChanged(bool, paramAnonymousInt, false);
          i = 1;
          a.b(a.this, paramAnonymousInt);
          if (i != 0) {
            a.c(a.this);
          }
          localObject = a.f(a.this);
          if (localObject != null) {
            ((aa)localObject).iF(paramAnonymousInt);
          }
          AppMethodBeat.o(223051);
          return;
        }
      }
    };
    AppMethodBeat.o(139367);
  }
  
  private aa Uu()
  {
    Object localObject3 = null;
    AppMethodBeat.i(139368);
    try
    {
      Object localObject1;
      if (this.cKI != null)
      {
        localObject1 = this.cKI;
        return localObject1;
      }
      if (!this.czr) {
        return null;
      }
      if ((this.cKG != null) && (this.cKG.cey() != null))
      {
        View localView = this.cKG.cey().getContentView();
        localObject1 = localObject3;
        if (this.cKG.cey() != null)
        {
          localObject1 = localObject3;
          if ((this.cKG.cey() instanceof ad)) {
            localObject1 = ((ad)this.cKG.cey()).cef();
          }
        }
        this.cKI = aa.b(localView, (com.tencent.mm.plugin.appbrand.n.a)localObject1);
        if (this.cKI != null)
        {
          this.cKJ = new EditText(this.cKI.getContext());
          this.cKI.a(this.cKN);
        }
        localObject1 = this.cKI;
        return localObject1;
      }
      return null;
    }
    finally
    {
      AppMethodBeat.o(139368);
    }
  }
  
  private void cy(boolean paramBoolean)
  {
    AppMethodBeat.i(228262);
    StringBuilder localStringBuilder = new StringBuilder("(function(){    var focusElement = document.activeElement;    if(focusElement){        if(focusElement.onkeyboardconfirm){            focusElement.onkeyboardconfirm();        }");
    if (!paramBoolean) {}
    for (String str = "        focusElement.blur();";; str = "")
    {
      str = str + "    }})();";
      getXWalkView().evaluateJavascript(str, new ValueCallback() {});
      AppMethodBeat.o(228262);
      return;
    }
  }
  
  public final int getToolBarHeight(int paramInt)
  {
    AppMethodBeat.i(139371);
    aa localaa = Uu();
    if (localaa != null)
    {
      this.cKK = localaa.getMinimumHeight();
      int i = this.cKK;
      AppMethodBeat.o(139371);
      return i + paramInt;
    }
    AppMethodBeat.o(139371);
    return 0;
  }
  
  public final boolean onHideKeyboard(String paramString, InputConnection paramInputConnection)
  {
    AppMethodBeat.i(139370);
    if (this.cKG != null)
    {
      paramString = Uu();
      if (paramString != null) {
        paramString.ca(false);
      }
    }
    if (this.cKH != null) {
      this.cKH.b(this.cKO);
    }
    this.czr = false;
    if (this.cKI != null) {
      this.cKI.b(this.cKN);
    }
    this.cKI = null;
    AppMethodBeat.o(139370);
    return false;
  }
  
  public final boolean onShowKeyboard(final String paramString, final InputConnection paramInputConnection, ResultReceiver paramResultReceiver)
  {
    boolean bool = true;
    AppMethodBeat.i(139369);
    this.czr = true;
    if (this.cKH == null) {
      this.cKH = n.dr(this.cKG.cey().getContentView());
    }
    if (this.cKH != null) {
      this.cKH.a(this.cKO);
    }
    paramString = new a(paramString);
    this.cKM = paramString.cKZ;
    if (this.cKG != null)
    {
      paramInputConnection = Uu();
      if ((paramInputConnection != null) && (paramString.cKW))
      {
        paramInputConnection.setComponentView(paramString.cKY);
        paramInputConnection.coX();
        if ((paramString.cKX) || (!"emoji".equals(paramString.cKU))) {
          break label181;
        }
      }
    }
    for (;;)
    {
      paramInputConnection.setCanSmileyInput(bool);
      paramInputConnection.setShowDoneButton(paramString.cKW);
      paramInputConnection.setOnDoneListener(new aa.c()
      {
        public final void cz(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(223119);
          Log.i("WebViewExtendTextAreaClient", "onInputDone#onShowKeyboard, fromDoneButton: %b, confirmHold: %b", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Boolean.valueOf(a.g(a.this)) });
          a.h(a.this);
          AppMethodBeat.o(223119);
        }
      });
      paramInputConnection.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(222179);
          a locala;
          if (a.i(a.this))
          {
            paramInputConnection.ca(paramString.cKW);
            locala = a.this;
            if (!a.i(a.this)) {
              break label72;
            }
          }
          label72:
          for (int i = a.e(a.this);; i = 0)
          {
            locala.onKeyboardHeightChanged(true, i, false);
            a.c(a.this);
            AppMethodBeat.o(222179);
            return;
          }
        }
      }, 200L);
      AppMethodBeat.o(139369);
      return false;
      label181:
      bool = false;
    }
  }
  
  public final boolean onShowKeyboardConfig(int paramInt1, int paramInt2, String paramString, int paramInt3, int paramInt4, EditorInfo paramEditorInfo)
  {
    Object localObject = null;
    AppMethodBeat.i(228257);
    Log.d("WebViewExtendTextAreaClient", "onShowKeyboardConfig");
    try
    {
      paramString = b.anD(new JSONObject(paramString).optString("confirm-type", null));
      if (paramString != null)
      {
        Log.i("WebViewExtendTextAreaClient", "onShowKeyboardConfig, confirmType: ".concat(String.valueOf(paramString)));
        if (b.rzX != paramString) {
          paramEditorInfo.imeOptions &= 0xBFFFFFFF;
        }
        paramEditorInfo.imeOptions |= paramString.rzY;
        this.cKL = paramString.rzY;
      }
      AppMethodBeat.o(228257);
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
    AppMethodBeat.i(228258);
    Log.d("WebViewExtendTextAreaClient", "performEditorAction, actionCode: ".concat(String.valueOf(paramInt)));
    if ((paramInt != 0) && (paramInt == this.cKL))
    {
      Log.i("WebViewExtendTextAreaClient", "performEditorAction, confirmHold: " + this.cKM);
      cy(this.cKM);
      AppMethodBeat.o(228258);
      return false;
    }
    AppMethodBeat.o(228258);
    return true;
  }
  
  public final class a
  {
    public String cKS;
    public String cKT;
    public String cKU;
    public Integer cKV;
    public boolean cKW;
    public boolean cKX;
    public boolean cKY;
    public boolean cKZ;
    
    /* Error */
    public a(String paramString)
    {
      // Byte code:
      //   0: aload_0
      //   1: aload_1
      //   2: putfield 30	com/tencent/luggage/xweb_ext/extendplugin/c/a$a:cKP	Lcom/tencent/luggage/xweb_ext/extendplugin/c/a;
      //   5: aload_0
      //   6: invokespecial 33	java/lang/Object:<init>	()V
      //   9: ldc 34
      //   11: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   14: aload_0
      //   15: ldc 42
      //   17: putfield 44	com/tencent/luggage/xweb_ext/extendplugin/c/a$a:cKS	Ljava/lang/String;
      //   20: aload_0
      //   21: ldc 42
      //   23: putfield 46	com/tencent/luggage/xweb_ext/extendplugin/c/a$a:cKT	Ljava/lang/String;
      //   26: aload_0
      //   27: ldc 42
      //   29: putfield 48	com/tencent/luggage/xweb_ext/extendplugin/c/a$a:cKU	Ljava/lang/String;
      //   32: aload_0
      //   33: aconst_null
      //   34: putfield 50	com/tencent/luggage/xweb_ext/extendplugin/c/a$a:cKV	Ljava/lang/Integer;
      //   37: aload_0
      //   38: iconst_0
      //   39: putfield 52	com/tencent/luggage/xweb_ext/extendplugin/c/a$a:cKW	Z
      //   42: aload_0
      //   43: iconst_0
      //   44: putfield 54	com/tencent/luggage/xweb_ext/extendplugin/c/a$a:cKX	Z
      //   47: aload_0
      //   48: iconst_0
      //   49: putfield 56	com/tencent/luggage/xweb_ext/extendplugin/c/a$a:cKY	Z
      //   52: aload_0
      //   53: iconst_0
      //   54: putfield 58	com/tencent/luggage/xweb_ext/extendplugin/c/a$a:cKZ	Z
      //   57: ldc 60
      //   59: ldc 62
      //   61: aload_2
      //   62: invokestatic 68	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
      //   65: invokevirtual 72	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
      //   68: invokestatic 77	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   71: aload_0
      //   72: aload_2
      //   73: putfield 44	com/tencent/luggage/xweb_ext/extendplugin/c/a$a:cKS	Ljava/lang/String;
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
      //   101: putfield 46	com/tencent/luggage/xweb_ext/extendplugin/c/a$a:cKT	Ljava/lang/String;
      //   104: aload_1
      //   105: ldc 93
      //   107: invokevirtual 88	org/json/JSONObject:has	(Ljava/lang/String;)Z
      //   110: ifeq +13 -> 123
      //   113: aload_0
      //   114: aload_1
      //   115: ldc 93
      //   117: invokevirtual 91	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
      //   120: putfield 48	com/tencent/luggage/xweb_ext/extendplugin/c/a$a:cKU	Ljava/lang/String;
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
      //   146: putfield 50	com/tencent/luggage/xweb_ext/extendplugin/c/a$a:cKV	Ljava/lang/Integer;
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
      //   169: putfield 52	com/tencent/luggage/xweb_ext/extendplugin/c/a$a:cKW	Z
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
      //   192: putfield 54	com/tencent/luggage/xweb_ext/extendplugin/c/a$a:cKX	Z
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
      //   215: putfield 56	com/tencent/luggage/xweb_ext/extendplugin/c/a$a:cKY	Z
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
      //   238: putfield 58	com/tencent/luggage/xweb_ext/extendplugin/c/a$a:cKZ	Z
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.c.a
 * JD-Core Version:    0.7.0.1
 */