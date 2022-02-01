package androidx.appcompat.view;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.a.j;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.view.menu.k;
import androidx.appcompat.widget.o;
import androidx.core.g.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;

public final class g
  extends MenuInflater
{
  static final Class<?>[] kP;
  static final Class<?>[] kQ;
  final Object[] kR;
  final Object[] kS;
  Object kT;
  Context mContext;
  
  static
  {
    Class[] arrayOfClass = new Class[1];
    arrayOfClass[0] = Context.class;
    kP = arrayOfClass;
    kQ = arrayOfClass;
  }
  
  public g(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(200641);
    this.mContext = paramContext;
    this.kR = new Object[] { paramContext };
    this.kS = this.kR;
    AppMethodBeat.o(200641);
  }
  
  private void a(XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Menu paramMenu)
  {
    AppMethodBeat.i(200651);
    b localb = new b(paramMenu);
    int i = paramXmlPullParser.getEventType();
    label54:
    int j;
    int k;
    if (i == 2)
    {
      paramMenu = paramXmlPullParser.getName();
      if (paramMenu.equals("menu"))
      {
        i = paramXmlPullParser.next();
        int m = 0;
        paramMenu = null;
        j = 0;
        k = i;
        i = m;
        label70:
        if (i != 0) {
          break label383;
        }
      }
    }
    switch (k)
    {
    default: 
    case 2: 
    case 3: 
      for (;;)
      {
        k = paramXmlPullParser.next();
        break label70;
        paramXmlPullParser = new RuntimeException("Expecting menu, got ".concat(String.valueOf(paramMenu)));
        AppMethodBeat.o(200651);
        throw paramXmlPullParser;
        j = paramXmlPullParser.next();
        i = j;
        if (j != 1) {
          break;
        }
        i = j;
        break label54;
        if (j == 0)
        {
          String str = paramXmlPullParser.getName();
          if (str.equals("group"))
          {
            localb.b(paramAttributeSet);
          }
          else if (str.equals("item"))
          {
            localb.c(paramAttributeSet);
          }
          else if (str.equals("menu"))
          {
            a(paramXmlPullParser, paramAttributeSet, localb.cz());
          }
          else
          {
            paramMenu = str;
            j = 1;
            continue;
            str = paramXmlPullParser.getName();
            if ((j != 0) && (str.equals(paramMenu)))
            {
              paramMenu = null;
              j = 0;
            }
            else if (str.equals("group"))
            {
              localb.cx();
            }
            else if (str.equals("item"))
            {
              if (!localb.lc) {
                if ((localb.lv != null) && (localb.lv.hasSubMenu())) {
                  localb.cz();
                } else {
                  localb.cy();
                }
              }
            }
            else if (str.equals("menu"))
            {
              i = 1;
            }
          }
        }
      }
    }
    paramXmlPullParser = new RuntimeException("Unexpected end of document");
    AppMethodBeat.o(200651);
    throw paramXmlPullParser;
    label383:
    AppMethodBeat.o(200651);
  }
  
  static Object p(Object paramObject)
  {
    AppMethodBeat.i(200660);
    for (;;)
    {
      if ((paramObject instanceof Activity))
      {
        AppMethodBeat.o(200660);
        return paramObject;
      }
      if (!(paramObject instanceof ContextWrapper)) {
        break;
      }
      paramObject = ((ContextWrapper)paramObject).getBaseContext();
    }
    AppMethodBeat.o(200660);
    return paramObject;
  }
  
  /* Error */
  public final void inflate(int paramInt, Menu paramMenu)
  {
    // Byte code:
    //   0: ldc 151
    //   2: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_2
    //   6: instanceof 153
    //   9: ifne +15 -> 24
    //   12: aload_0
    //   13: iload_1
    //   14: aload_2
    //   15: invokespecial 155	android/view/MenuInflater:inflate	(ILandroid/view/Menu;)V
    //   18: ldc 151
    //   20: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   23: return
    //   24: aconst_null
    //   25: astore_3
    //   26: aconst_null
    //   27: astore 5
    //   29: aconst_null
    //   30: astore 4
    //   32: aload_0
    //   33: getfield 44	androidx/appcompat/view/g:mContext	Landroid/content/Context;
    //   36: invokevirtual 159	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   39: iload_1
    //   40: invokevirtual 165	android/content/res/Resources:getLayout	(I)Landroid/content/res/XmlResourceParser;
    //   43: astore 6
    //   45: aload 6
    //   47: astore 4
    //   49: aload 6
    //   51: astore_3
    //   52: aload 6
    //   54: astore 5
    //   56: aload_0
    //   57: aload 6
    //   59: aload 6
    //   61: invokestatic 171	android/util/Xml:asAttributeSet	(Lorg/xmlpull/v1/XmlPullParser;)Landroid/util/AttributeSet;
    //   64: aload_2
    //   65: invokespecial 111	androidx/appcompat/view/g:a	(Lorg/xmlpull/v1/XmlPullParser;Landroid/util/AttributeSet;Landroid/view/Menu;)V
    //   68: aload 6
    //   70: ifnull +90 -> 160
    //   73: aload 6
    //   75: invokeinterface 176 1 0
    //   80: ldc 151
    //   82: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   85: return
    //   86: astore_2
    //   87: aload 4
    //   89: astore_3
    //   90: new 178	android/view/InflateException
    //   93: dup
    //   94: ldc 180
    //   96: aload_2
    //   97: invokespecial 183	android/view/InflateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   100: astore_2
    //   101: aload 4
    //   103: astore_3
    //   104: ldc 151
    //   106: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   109: aload 4
    //   111: astore_3
    //   112: aload_2
    //   113: athrow
    //   114: astore_2
    //   115: aload_3
    //   116: ifnull +9 -> 125
    //   119: aload_3
    //   120: invokeinterface 176 1 0
    //   125: ldc 151
    //   127: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   130: aload_2
    //   131: athrow
    //   132: astore_2
    //   133: aload 5
    //   135: astore_3
    //   136: new 178	android/view/InflateException
    //   139: dup
    //   140: ldc 180
    //   142: aload_2
    //   143: invokespecial 183	android/view/InflateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   146: astore_2
    //   147: aload 5
    //   149: astore_3
    //   150: ldc 151
    //   152: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   155: aload 5
    //   157: astore_3
    //   158: aload_2
    //   159: athrow
    //   160: ldc 151
    //   162: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   165: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	166	0	this	g
    //   0	166	1	paramInt	int
    //   0	166	2	paramMenu	Menu
    //   25	133	3	localObject1	Object
    //   30	80	4	localObject2	Object
    //   27	129	5	localObject3	Object
    //   43	31	6	localXmlResourceParser	android.content.res.XmlResourceParser
    // Exception table:
    //   from	to	target	type
    //   32	45	86	org/xmlpull/v1/XmlPullParserException
    //   56	68	86	org/xmlpull/v1/XmlPullParserException
    //   32	45	114	finally
    //   56	68	114	finally
    //   90	101	114	finally
    //   104	109	114	finally
    //   112	114	114	finally
    //   136	147	114	finally
    //   150	155	114	finally
    //   158	160	114	finally
    //   32	45	132	java/io/IOException
    //   56	68	132	java/io/IOException
  }
  
  final class b
  {
    private Menu kV;
    private int kW;
    private int kX;
    private int kY;
    private int kZ;
    private boolean la;
    private boolean lb;
    boolean lc;
    private int ld;
    private int le;
    private CharSequence lf;
    private CharSequence lg;
    private int lh;
    private char li;
    private int lj;
    private char lk;
    private int ll;
    private int lm;
    private boolean ln;
    private boolean lo;
    private boolean lp;
    private int lq;
    private int lr;
    private String ls;
    private String lt;
    private String lu;
    androidx.core.g.b lv;
    private CharSequence lw;
    private CharSequence lx;
    private ColorStateList ly;
    private PorterDuff.Mode lz;
    
    public b(Menu paramMenu)
    {
      AppMethodBeat.i(200738);
      this.ly = null;
      this.lz = null;
      this.kV = paramMenu;
      cx();
      AppMethodBeat.o(200738);
    }
    
    private void a(MenuItem paramMenuItem)
    {
      int i = 1;
      AppMethodBeat.i(200774);
      Object localObject = paramMenuItem.setChecked(this.ln).setVisible(this.lo).setEnabled(this.lp);
      if (this.lm > 0) {}
      for (boolean bool = true;; bool = false)
      {
        ((MenuItem)localObject).setCheckable(bool).setTitleCondensed(this.lg).setIcon(this.lh);
        if (this.lq >= 0) {
          paramMenuItem.setShowAsAction(this.lq);
        }
        if (this.lu == null) {
          break label182;
        }
        if (!g.this.mContext.isRestricted()) {
          break;
        }
        paramMenuItem = new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
        AppMethodBeat.o(200774);
        throw paramMenuItem;
      }
      localObject = g.this;
      if (((g)localObject).kT == null) {
        ((g)localObject).kT = g.p(((g)localObject).mContext);
      }
      paramMenuItem.setOnMenuItemClickListener(new g.a(((g)localObject).kT, this.lu));
      label182:
      if (this.lm >= 2)
      {
        if ((paramMenuItem instanceof j)) {
          ((j)paramMenuItem).M(true);
        }
      }
      else
      {
        if (this.ls == null) {
          break label438;
        }
        paramMenuItem.setActionView((View)newInstance(this.ls, g.kP, g.this.kR));
      }
      for (;;)
      {
        for (;;)
        {
          if ((this.lr > 0) && (i == 0)) {
            paramMenuItem.setActionView(this.lr);
          }
          if (this.lv != null) {
            i.a(paramMenuItem, this.lv);
          }
          i.a(paramMenuItem, this.lw);
          i.b(paramMenuItem, this.lx);
          i.b(paramMenuItem, this.li, this.lj);
          i.a(paramMenuItem, this.lk, this.ll);
          if (this.lz != null) {
            i.a(paramMenuItem, this.lz);
          }
          if (this.ly != null) {
            i.a(paramMenuItem, this.ly);
          }
          AppMethodBeat.o(200774);
          return;
          if (!(paramMenuItem instanceof k)) {
            break;
          }
          localObject = (k)paramMenuItem;
          try
          {
            if (((k)localObject).og == null) {
              ((k)localObject).og = ((androidx.core.a.a.b)((k)localObject).mr).getClass().getDeclaredMethod("setExclusiveCheckable", new Class[] { Boolean.TYPE });
            }
            ((k)localObject).og.invoke(((k)localObject).mr, new Object[] { Boolean.TRUE });
          }
          catch (Exception localException) {}
        }
        break;
        label438:
        i = 0;
      }
    }
    
    private <T> T newInstance(String paramString, Class<?>[] paramArrayOfClass, Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(200788);
      try
      {
        paramString = g.this.mContext.getClassLoader().loadClass(paramString).getConstructor(paramArrayOfClass);
        paramString.setAccessible(true);
        paramString = paramString.newInstance(paramArrayOfObject);
        AppMethodBeat.o(200788);
        return paramString;
      }
      catch (Exception paramString)
      {
        AppMethodBeat.o(200788);
      }
      return null;
    }
    
    private static char r(String paramString)
    {
      AppMethodBeat.i(200748);
      if (paramString == null)
      {
        AppMethodBeat.o(200748);
        return '\000';
      }
      char c = paramString.charAt(0);
      AppMethodBeat.o(200748);
      return c;
    }
    
    public final void b(AttributeSet paramAttributeSet)
    {
      AppMethodBeat.i(200814);
      paramAttributeSet = g.this.mContext.obtainStyledAttributes(paramAttributeSet, a.j.MenuGroup);
      this.kW = paramAttributeSet.getResourceId(a.j.MenuGroup_android_id, 0);
      this.kX = paramAttributeSet.getInt(a.j.MenuGroup_android_menuCategory, 0);
      this.kY = paramAttributeSet.getInt(a.j.MenuGroup_android_orderInCategory, 0);
      this.kZ = paramAttributeSet.getInt(a.j.MenuGroup_android_checkableBehavior, 0);
      this.la = paramAttributeSet.getBoolean(a.j.MenuGroup_android_visible, true);
      this.lb = paramAttributeSet.getBoolean(a.j.MenuGroup_android_enabled, true);
      paramAttributeSet.recycle();
      AppMethodBeat.o(200814);
    }
    
    public final void c(AttributeSet paramAttributeSet)
    {
      int j = 1;
      AppMethodBeat.i(200832);
      paramAttributeSet = g.this.mContext.obtainStyledAttributes(paramAttributeSet, a.j.MenuItem);
      this.ld = paramAttributeSet.getResourceId(a.j.MenuItem_android_id, 0);
      this.le = (paramAttributeSet.getInt(a.j.MenuItem_android_menuCategory, this.kX) & 0xFFFF0000 | paramAttributeSet.getInt(a.j.MenuItem_android_orderInCategory, this.kY) & 0xFFFF);
      this.lf = paramAttributeSet.getText(a.j.MenuItem_android_title);
      this.lg = paramAttributeSet.getText(a.j.MenuItem_android_titleCondensed);
      this.lh = paramAttributeSet.getResourceId(a.j.MenuItem_android_icon, 0);
      this.li = r(paramAttributeSet.getString(a.j.MenuItem_android_alphabeticShortcut));
      this.lj = paramAttributeSet.getInt(a.j.MenuItem_alphabeticModifiers, 4096);
      this.lk = r(paramAttributeSet.getString(a.j.MenuItem_android_numericShortcut));
      this.ll = paramAttributeSet.getInt(a.j.MenuItem_numericModifiers, 4096);
      int i;
      if (paramAttributeSet.hasValue(a.j.MenuItem_android_checkable)) {
        if (paramAttributeSet.getBoolean(a.j.MenuItem_android_checkable, false))
        {
          i = 1;
          this.lm = i;
          label188:
          this.ln = paramAttributeSet.getBoolean(a.j.MenuItem_android_checked, false);
          this.lo = paramAttributeSet.getBoolean(a.j.MenuItem_android_visible, this.la);
          this.lp = paramAttributeSet.getBoolean(a.j.MenuItem_android_enabled, this.lb);
          this.lq = paramAttributeSet.getInt(a.j.MenuItem_showAsAction, -1);
          this.lu = paramAttributeSet.getString(a.j.MenuItem_android_onClick);
          this.lr = paramAttributeSet.getResourceId(a.j.MenuItem_actionLayout, 0);
          this.ls = paramAttributeSet.getString(a.j.MenuItem_actionViewClass);
          this.lt = paramAttributeSet.getString(a.j.MenuItem_actionProviderClass);
          if (this.lt == null) {
            break label443;
          }
          i = j;
          label296:
          if ((i == 0) || (this.lr != 0) || (this.ls != null)) {
            break label448;
          }
          this.lv = ((androidx.core.g.b)newInstance(this.lt, g.kQ, g.this.kS));
          label339:
          this.lw = paramAttributeSet.getText(a.j.MenuItem_contentDescription);
          this.lx = paramAttributeSet.getText(a.j.MenuItem_tooltipText);
          if (!paramAttributeSet.hasValue(a.j.MenuItem_iconTintMode)) {
            break label456;
          }
          this.lz = o.c(paramAttributeSet.getInt(a.j.MenuItem_iconTintMode, -1), this.lz);
          label390:
          if (!paramAttributeSet.hasValue(a.j.MenuItem_iconTint)) {
            break label464;
          }
        }
      }
      label443:
      label448:
      label456:
      label464:
      for (this.ly = paramAttributeSet.getColorStateList(a.j.MenuItem_iconTint);; this.ly = null)
      {
        paramAttributeSet.recycle();
        this.lc = false;
        AppMethodBeat.o(200832);
        return;
        i = 0;
        break;
        this.lm = this.kZ;
        break label188;
        i = 0;
        break label296;
        this.lv = null;
        break label339;
        this.lz = null;
        break label390;
      }
    }
    
    public final void cx()
    {
      this.kW = 0;
      this.kX = 0;
      this.kY = 0;
      this.kZ = 0;
      this.la = true;
      this.lb = true;
    }
    
    public final void cy()
    {
      AppMethodBeat.i(200841);
      this.lc = true;
      a(this.kV.add(this.kW, this.ld, this.le, this.lf));
      AppMethodBeat.o(200841);
    }
    
    public final SubMenu cz()
    {
      AppMethodBeat.i(200850);
      this.lc = true;
      SubMenu localSubMenu = this.kV.addSubMenu(this.kW, this.ld, this.le, this.lf);
      a(localSubMenu.getItem());
      AppMethodBeat.o(200850);
      return localSubMenu;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.appcompat.view.g
 * JD-Core Version:    0.7.0.1
 */