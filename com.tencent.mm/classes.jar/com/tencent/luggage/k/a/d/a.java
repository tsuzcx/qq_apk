package com.tencent.luggage.k.a.d;

import android.os.ResultReceiver;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ab;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.page.as;
import com.tencent.mm.plugin.appbrand.widget.input.d.b;
import com.tencent.mm.plugin.appbrand.widget.input.n;
import com.tencent.mm.plugin.appbrand.widget.input.u;
import com.tencent.mm.plugin.appbrand.widget.input.u.c;
import com.tencent.mm.plugin.appbrand.widget.input.w;
import com.tencent.mm.plugin.appbrand.widget.input.w.c;
import com.tencent.mm.plugin.appbrand.z.g;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.b.k;
import org.json.JSONObject;
import org.xwalk.core.XWalkExtendTextAreaClient;
import org.xwalk.core.XWalkView;

public final class a
  extends XWalkExtendTextAreaClient
{
  private final String TAG;
  public as ckY;
  private u ckZ;
  private int cla;
  private final u.c clb;
  
  public a(XWalkView paramXWalkView)
  {
    super(paramXWalkView);
    AppMethodBeat.i(139367);
    this.TAG = "WebViewExtendTextAreaClient";
    this.cla = 0;
    this.clb = new u.c()
    {
      private final ab cdM;
      private int cdN;
      
      public final void bt(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(139364);
        Object localObject = a.b(a.this).bqP();
        c localc = a.b(a.this).bqQ();
        if (localObject != null)
        {
          ab localab = this.cdM;
          if (paramAnonymousBoolean)
          {
            i = this.cdN;
            k.h(localc, "service");
            k.h(localObject, "page");
            localab.q("height", Integer.valueOf(g.vc(i)));
            localab.g(localc).beN();
            localab.g((c)localObject).beN();
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
            i = this.cdN;
            label115:
            ((w)localObject).gw(i);
          }
          localObject = a.this;
          if (!paramAnonymousBoolean) {
            break label157;
          }
        }
        label152:
        label157:
        for (int i = this.cdN;; i = 0)
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
      
      public final int getHeight()
      {
        return this.cdN;
      }
      
      public final void gw(int paramAnonymousInt)
      {
        AppMethodBeat.i(139363);
        this.cdN = paramAnonymousInt;
        w localw = a.a(a.this);
        if (localw != null) {
          localw.gw(paramAnonymousInt);
        }
        AppMethodBeat.o(139363);
      }
    };
    AppMethodBeat.o(139367);
  }
  
  private w Fu()
  {
    AppMethodBeat.i(139368);
    if ((this.ckY != null) && (this.ckY.bqP() != null))
    {
      w localw = w.dj(this.ckY.bqP().getContentView());
      AppMethodBeat.o(139368);
      return localw;
    }
    AppMethodBeat.o(139368);
    return null;
  }
  
  private void Fv()
  {
    AppMethodBeat.i(206665);
    getXWalkView().evaluateJavascript("(function(){var focusElement = document.activeElement;if(focusElement){if(focusElement.onkeyboardconfirm){focusElement.onkeyboardconfirm();}focusElement.blur();}})();", new ValueCallback() {});
    AppMethodBeat.o(206665);
  }
  
  public final int getToolBarHeight(int paramInt)
  {
    AppMethodBeat.i(139371);
    w localw = Fu();
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
    if (this.ckY != null)
    {
      paramString = Fu();
      if (paramString != null) {
        paramString.bt(false);
      }
    }
    if (this.ckZ != null) {
      this.ckZ.b(this.clb);
    }
    AppMethodBeat.o(139370);
    return false;
  }
  
  public final boolean onShowKeyboard(String paramString, InputConnection paramInputConnection, ResultReceiver paramResultReceiver)
  {
    AppMethodBeat.i(139369);
    if (this.ckZ == null) {
      this.ckZ = n.dd(this.ckY.bqP().getContentView());
    }
    if (this.ckZ != null) {
      this.ckZ.a(this.clb);
    }
    paramString = new a(paramString);
    if (this.ckY != null)
    {
      paramInputConnection = Fu();
      if (paramInputConnection != null) {
        if (paramString.clh) {
          if ((paramString.cli) || (!"emoji".equals(paramString.clf))) {
            break label145;
          }
        }
      }
    }
    label145:
    for (boolean bool = true;; bool = false)
    {
      paramInputConnection.setCanSmileyInput(bool);
      paramInputConnection.setShowDoneButton(paramString.clh);
      paramInputConnection.setOnDoneListener(new w.c()
      {
        public final void bM(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(139365);
          a.c(a.this);
          AppMethodBeat.o(139365);
        }
      });
      paramInputConnection.bt(paramString.clh);
      AppMethodBeat.o(139369);
      return false;
    }
  }
  
  public final boolean onShowKeyboardConfig(int paramInt1, int paramInt2, String paramString, int paramInt3, int paramInt4, EditorInfo paramEditorInfo)
  {
    Object localObject = null;
    AppMethodBeat.i(206663);
    ac.d("WebViewExtendTextAreaClient", "onShowKeyboardConfig");
    try
    {
      paramString = b.RV(new JSONObject(paramString).optString("confirm-type", null));
      if (paramString != null)
      {
        ac.i("WebViewExtendTextAreaClient", "onShowKeyboardConfig, confirmType: ".concat(String.valueOf(paramString)));
        paramEditorInfo.imeOptions &= 0xBFFFFFFF;
        paramEditorInfo.imeOptions |= paramString.mIp;
        this.cla = paramString.mIp;
      }
      AppMethodBeat.o(206663);
      return false;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        ac.w("WebViewExtendTextAreaClient", "onShowKeyboardConfig, get confirm-type error");
        paramString = localObject;
      }
    }
  }
  
  public final boolean performEditorAction(int paramInt)
  {
    AppMethodBeat.i(206664);
    ac.d("WebViewExtendTextAreaClient", "performEditorAction, actionCode: ".concat(String.valueOf(paramInt)));
    switch (paramInt)
    {
    case 6: 
    default: 
      if ((paramInt != 0) && (paramInt == this.cla))
      {
        ac.i("WebViewExtendTextAreaClient", "performEditorAction, doOnKeyboardConfirmLogic");
        Fv();
        AppMethodBeat.o(206664);
        return false;
      }
      break;
    case 5: 
    case 7: 
      AppMethodBeat.o(206664);
      return true;
    }
    AppMethodBeat.o(206664);
    return true;
  }
  
  public final class a
  {
    public String cld;
    public String cle;
    public String clf;
    public Integer clg;
    public boolean clh;
    public boolean cli;
    
    /* Error */
    public a(String paramString)
    {
      // Byte code:
      //   0: aload_0
      //   1: aload_1
      //   2: putfield 28	com/tencent/luggage/k/a/d/a$a:clc	Lcom/tencent/luggage/k/a/d/a;
      //   5: aload_0
      //   6: invokespecial 31	java/lang/Object:<init>	()V
      //   9: ldc 32
      //   11: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   14: aload_0
      //   15: ldc 40
      //   17: putfield 42	com/tencent/luggage/k/a/d/a$a:cld	Ljava/lang/String;
      //   20: aload_0
      //   21: ldc 40
      //   23: putfield 44	com/tencent/luggage/k/a/d/a$a:cle	Ljava/lang/String;
      //   26: aload_0
      //   27: ldc 40
      //   29: putfield 46	com/tencent/luggage/k/a/d/a$a:clf	Ljava/lang/String;
      //   32: aload_0
      //   33: aconst_null
      //   34: putfield 48	com/tencent/luggage/k/a/d/a$a:clg	Ljava/lang/Integer;
      //   37: aload_0
      //   38: iconst_0
      //   39: putfield 50	com/tencent/luggage/k/a/d/a$a:clh	Z
      //   42: aload_0
      //   43: iconst_0
      //   44: putfield 52	com/tencent/luggage/k/a/d/a$a:cli	Z
      //   47: ldc 54
      //   49: ldc 56
      //   51: aload_2
      //   52: invokestatic 62	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
      //   55: invokevirtual 66	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
      //   58: invokestatic 71	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   61: aload_0
      //   62: aload_2
      //   63: putfield 42	com/tencent/luggage/k/a/d/a$a:cld	Ljava/lang/String;
      //   66: new 73	org/json/JSONObject
      //   69: dup
      //   70: aload_2
      //   71: invokespecial 76	org/json/JSONObject:<init>	(Ljava/lang/String;)V
      //   74: astore_1
      //   75: aload_1
      //   76: ldc 78
      //   78: invokevirtual 82	org/json/JSONObject:has	(Ljava/lang/String;)Z
      //   81: ifeq +13 -> 94
      //   84: aload_0
      //   85: aload_1
      //   86: ldc 78
      //   88: invokevirtual 85	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
      //   91: putfield 44	com/tencent/luggage/k/a/d/a$a:cle	Ljava/lang/String;
      //   94: aload_1
      //   95: ldc 87
      //   97: invokevirtual 82	org/json/JSONObject:has	(Ljava/lang/String;)Z
      //   100: ifeq +13 -> 113
      //   103: aload_0
      //   104: aload_1
      //   105: ldc 87
      //   107: invokevirtual 85	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
      //   110: putfield 46	com/tencent/luggage/k/a/d/a$a:clf	Ljava/lang/String;
      //   113: aload_1
      //   114: ldc 89
      //   116: invokevirtual 82	org/json/JSONObject:has	(Ljava/lang/String;)Z
      //   119: ifeq +20 -> 139
      //   122: aload_0
      //   123: aload_1
      //   124: ldc 89
      //   126: invokevirtual 85	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
      //   129: iconst_0
      //   130: invokestatic 95	com/tencent/mm/sdk/platformtools/bs:getInt	(Ljava/lang/String;I)I
      //   133: invokestatic 100	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   136: putfield 48	com/tencent/luggage/k/a/d/a$a:clg	Ljava/lang/Integer;
      //   139: aload_1
      //   140: ldc 102
      //   142: invokevirtual 82	org/json/JSONObject:has	(Ljava/lang/String;)Z
      //   145: ifeq +17 -> 162
      //   148: aload_0
      //   149: aload_1
      //   150: ldc 102
      //   152: invokevirtual 85	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
      //   155: iconst_0
      //   156: invokestatic 106	com/tencent/mm/sdk/platformtools/bs:getBoolean	(Ljava/lang/String;Z)Z
      //   159: putfield 50	com/tencent/luggage/k/a/d/a$a:clh	Z
      //   162: aload_1
      //   163: ldc 108
      //   165: invokevirtual 82	org/json/JSONObject:has	(Ljava/lang/String;)Z
      //   168: ifeq +17 -> 185
      //   171: aload_0
      //   172: aload_1
      //   173: ldc 108
      //   175: invokevirtual 85	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
      //   178: iconst_0
      //   179: invokestatic 106	com/tencent/mm/sdk/platformtools/bs:getBoolean	(Ljava/lang/String;Z)Z
      //   182: putfield 52	com/tencent/luggage/k/a/d/a$a:cli	Z
      //   185: ldc 32
      //   187: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   190: return
      //   191: astore_1
      //   192: ldc 54
      //   194: ldc 113
      //   196: invokestatic 116	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   199: new 73	org/json/JSONObject
      //   202: dup
      //   203: invokespecial 117	org/json/JSONObject:<init>	()V
      //   206: astore_1
      //   207: goto -132 -> 75
      //   210: astore_2
      //   211: ldc 54
      //   213: ldc 119
      //   215: invokestatic 116	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   218: goto -124 -> 94
      //   221: astore_2
      //   222: ldc 54
      //   224: ldc 121
      //   226: invokestatic 116	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   229: goto -116 -> 113
      //   232: astore_2
      //   233: ldc 54
      //   235: ldc 123
      //   237: invokestatic 116	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   240: goto -101 -> 139
      //   243: astore_2
      //   244: ldc 54
      //   246: ldc 125
      //   248: invokestatic 116	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   251: goto -112 -> 139
      //   254: astore_2
      //   255: ldc 54
      //   257: ldc 125
      //   259: invokestatic 116	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   262: goto -123 -> 139
      //   265: astore_2
      //   266: ldc 54
      //   268: ldc 127
      //   270: invokestatic 116	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   273: goto -111 -> 162
      //   276: astore_2
      //   277: ldc 54
      //   279: ldc 127
      //   281: invokestatic 116	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   284: goto -122 -> 162
      //   287: astore_1
      //   288: ldc 54
      //   290: ldc 129
      //   292: invokestatic 116	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   295: ldc 32
      //   297: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   300: return
      //   301: astore_1
      //   302: ldc 54
      //   304: ldc 129
      //   306: invokestatic 116	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   309: ldc 32
      //   311: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   314: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	315	0	this	a
      //   0	315	1	this$1	a
      //   0	315	2	paramString	String
      // Exception table:
      //   from	to	target	type
      //   66	75	191	java/lang/Exception
      //   75	94	210	org/json/JSONException
      //   94	113	221	org/json/JSONException
      //   113	139	232	org/json/JSONException
      //   113	139	243	java/lang/NumberFormatException
      //   113	139	254	java/lang/Exception
      //   139	162	265	org/json/JSONException
      //   139	162	276	java/lang/Exception
      //   162	185	287	org/json/JSONException
      //   162	185	301	java/lang/Exception
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.k.a.d.a
 * JD-Core Version:    0.7.0.1
 */