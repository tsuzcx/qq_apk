package androidx.appcompat.view;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.os.Build.VERSION;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;

public final class g
  extends MenuInflater
{
  static final Class<?>[] jT;
  static final Class<?>[] jU;
  final Object[] jV;
  final Object[] jW;
  Object jX;
  Context mContext;
  
  static
  {
    Class[] arrayOfClass = new Class[1];
    arrayOfClass[0] = Context.class;
    jT = arrayOfClass;
    jU = arrayOfClass;
  }
  
  public g(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(238997);
    this.mContext = paramContext;
    this.jV = new Object[] { paramContext };
    this.jW = this.jV;
    AppMethodBeat.o(238997);
  }
  
  private void a(XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Menu paramMenu)
  {
    AppMethodBeat.i(239000);
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
        AppMethodBeat.o(239000);
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
            a(paramXmlPullParser, paramAttributeSet, localb.bG());
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
              localb.bE();
            }
            else if (str.equals("item"))
            {
              if (!localb.kg) {
                if ((localb.kz != null) && (localb.kz.hasSubMenu())) {
                  localb.bG();
                } else {
                  localb.bF();
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
    AppMethodBeat.o(239000);
    throw paramXmlPullParser;
    label383:
    AppMethodBeat.o(239000);
  }
  
  static Object m(Object paramObject)
  {
    AppMethodBeat.i(239001);
    for (;;)
    {
      if ((paramObject instanceof Activity))
      {
        AppMethodBeat.o(239001);
        return paramObject;
      }
      if (!(paramObject instanceof ContextWrapper)) {
        break;
      }
      paramObject = ((ContextWrapper)paramObject).getBaseContext();
    }
    AppMethodBeat.o(239001);
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
    private Menu jZ;
    private CharSequence kA;
    private CharSequence kB;
    private ColorStateList kC;
    private PorterDuff.Mode kD;
    private int ka;
    private int kb;
    private int kc;
    private int kd;
    private boolean ke;
    private boolean kf;
    boolean kg;
    private int kh;
    private int ki;
    private CharSequence kj;
    private CharSequence kk;
    private int kl;
    private char km;
    private int kn;
    private char ko;
    private int kp;
    private int kq;
    private boolean kr;
    private boolean ks;
    private boolean kt;
    private int ku;
    private int kv;
    private String kw;
    private String kx;
    private String ky;
    androidx.core.g.b kz;
    
    public b(Menu paramMenu)
    {
      AppMethodBeat.i(238976);
      this.kC = null;
      this.kD = null;
      this.jZ = paramMenu;
      bE();
      AppMethodBeat.o(238976);
    }
    
    private void a(MenuItem paramMenuItem)
    {
      int i = 1;
      AppMethodBeat.i(238988);
      Object localObject = paramMenuItem.setChecked(this.kr).setVisible(this.ks).setEnabled(this.kt);
      if (this.kq > 0) {}
      for (boolean bool = true;; bool = false)
      {
        ((MenuItem)localObject).setCheckable(bool).setTitleCondensed(this.kk).setIcon(this.kl);
        if (this.ku >= 0) {
          paramMenuItem.setShowAsAction(this.ku);
        }
        if (this.ky == null) {
          break label185;
        }
        if (!g.this.mContext.isRestricted()) {
          break;
        }
        paramMenuItem = new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
        AppMethodBeat.o(238988);
        throw paramMenuItem;
      }
      localObject = g.this;
      if (((g)localObject).jX == null) {
        ((g)localObject).jX = g.m(((g)localObject).mContext);
      }
      paramMenuItem.setOnMenuItemClickListener(new g.a(((g)localObject).jX, this.ky));
      label185:
      if (this.kq >= 2)
      {
        if ((paramMenuItem instanceof j)) {
          ((j)paramMenuItem).I(true);
        }
      }
      else
      {
        if (this.kw == null) {
          break label682;
        }
        paramMenuItem.setActionView((View)newInstance(this.kw, g.jT, g.this.jV));
      }
      for (;;)
      {
        if ((this.kv > 0) && (i == 0)) {
          paramMenuItem.setActionView(this.kv);
        }
        if (this.kz != null)
        {
          localObject = this.kz;
          if ((paramMenuItem instanceof androidx.core.a.a.b)) {
            ((androidx.core.a.a.b)paramMenuItem).a((androidx.core.g.b)localObject);
          }
        }
        localObject = this.kA;
        label322:
        label347:
        char c;
        if ((paramMenuItem instanceof androidx.core.a.a.b))
        {
          ((androidx.core.a.a.b)paramMenuItem).b((CharSequence)localObject);
          localObject = this.kB;
          if (!(paramMenuItem instanceof androidx.core.a.a.b)) {
            break label579;
          }
          ((androidx.core.a.a.b)paramMenuItem).c((CharSequence)localObject);
          c = this.km;
          i = this.kn;
          if (!(paramMenuItem instanceof androidx.core.a.a.b)) {
            break label599;
          }
          ((androidx.core.a.a.b)paramMenuItem).setAlphabeticShortcut(c, i);
          label376:
          c = this.ko;
          i = this.kp;
          if (!(paramMenuItem instanceof androidx.core.a.a.b)) {
            break label619;
          }
          ((androidx.core.a.a.b)paramMenuItem).setNumericShortcut(c, i);
          label405:
          if (this.kD != null)
          {
            localObject = this.kD;
            if (!(paramMenuItem instanceof androidx.core.a.a.b)) {
              break label639;
            }
            ((androidx.core.a.a.b)paramMenuItem).setIconTintMode((PorterDuff.Mode)localObject);
          }
        }
        label659:
        for (;;)
        {
          for (;;)
          {
            if (this.kC == null) {
              break label676;
            }
            localObject = this.kC;
            if (!(paramMenuItem instanceof androidx.core.a.a.b)) {
              break label659;
            }
            ((androidx.core.a.a.b)paramMenuItem).setIconTintList((ColorStateList)localObject);
            AppMethodBeat.o(238988);
            return;
            if (!(paramMenuItem instanceof k)) {
              break;
            }
            localObject = (k)paramMenuItem;
            try
            {
              if (((k)localObject).nk == null) {
                ((k)localObject).nk = ((androidx.core.a.a.b)((k)localObject).lv).getClass().getDeclaredMethod("setExclusiveCheckable", new Class[] { Boolean.TYPE });
              }
              ((k)localObject).nk.invoke(((k)localObject).lv, new Object[] { Boolean.TRUE });
            }
            catch (Exception localException) {}
          }
          break;
          if (Build.VERSION.SDK_INT < 26) {
            break label322;
          }
          paramMenuItem.setContentDescription(localException);
          break label322;
          label579:
          if (Build.VERSION.SDK_INT < 26) {
            break label347;
          }
          paramMenuItem.setTooltipText(localException);
          break label347;
          label599:
          if (Build.VERSION.SDK_INT < 26) {
            break label376;
          }
          paramMenuItem.setAlphabeticShortcut(c, i);
          break label376;
          label619:
          if (Build.VERSION.SDK_INT < 26) {
            break label405;
          }
          paramMenuItem.setNumericShortcut(c, i);
          break label405;
          label639:
          if (Build.VERSION.SDK_INT >= 26)
          {
            paramMenuItem.setIconTintMode(localException);
            continue;
            if (Build.VERSION.SDK_INT >= 26) {
              paramMenuItem.setIconTintList(localException);
            }
          }
        }
        label676:
        AppMethodBeat.o(238988);
        return;
        label682:
        i = 0;
      }
    }
    
    private <T> T newInstance(String paramString, Class<?>[] paramArrayOfClass, Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(238992);
      try
      {
        paramString = g.this.mContext.getClassLoader().loadClass(paramString).getConstructor(paramArrayOfClass);
        paramString.setAccessible(true);
        paramString = paramString.newInstance(paramArrayOfObject);
        AppMethodBeat.o(238992);
        return paramString;
      }
      catch (Exception paramString)
      {
        AppMethodBeat.o(238992);
      }
      return null;
    }
    
    private static char q(String paramString)
    {
      AppMethodBeat.i(238984);
      if (paramString == null)
      {
        AppMethodBeat.o(238984);
        return '\000';
      }
      char c = paramString.charAt(0);
      AppMethodBeat.o(238984);
      return c;
    }
    
    public final void b(AttributeSet paramAttributeSet)
    {
      AppMethodBeat.i(238979);
      paramAttributeSet = g.this.mContext.obtainStyledAttributes(paramAttributeSet, a.j.MenuGroup);
      this.ka = paramAttributeSet.getResourceId(a.j.MenuGroup_android_id, 0);
      this.kb = paramAttributeSet.getInt(a.j.MenuGroup_android_menuCategory, 0);
      this.kc = paramAttributeSet.getInt(a.j.MenuGroup_android_orderInCategory, 0);
      this.kd = paramAttributeSet.getInt(a.j.MenuGroup_android_checkableBehavior, 0);
      this.ke = paramAttributeSet.getBoolean(a.j.MenuGroup_android_visible, true);
      this.kf = paramAttributeSet.getBoolean(a.j.MenuGroup_android_enabled, true);
      paramAttributeSet.recycle();
      AppMethodBeat.o(238979);
    }
    
    public final void bE()
    {
      this.ka = 0;
      this.kb = 0;
      this.kc = 0;
      this.kd = 0;
      this.ke = true;
      this.kf = true;
    }
    
    public final void bF()
    {
      AppMethodBeat.i(238989);
      this.kg = true;
      a(this.jZ.add(this.ka, this.kh, this.ki, this.kj));
      AppMethodBeat.o(238989);
    }
    
    public final SubMenu bG()
    {
      AppMethodBeat.i(238990);
      this.kg = true;
      SubMenu localSubMenu = this.jZ.addSubMenu(this.ka, this.kh, this.ki, this.kj);
      a(localSubMenu.getItem());
      AppMethodBeat.o(238990);
      return localSubMenu;
    }
    
    public final void c(AttributeSet paramAttributeSet)
    {
      int j = 1;
      AppMethodBeat.i(238982);
      paramAttributeSet = g.this.mContext.obtainStyledAttributes(paramAttributeSet, a.j.MenuItem);
      this.kh = paramAttributeSet.getResourceId(a.j.MenuItem_android_id, 0);
      this.ki = (paramAttributeSet.getInt(a.j.MenuItem_android_menuCategory, this.kb) & 0xFFFF0000 | paramAttributeSet.getInt(a.j.MenuItem_android_orderInCategory, this.kc) & 0xFFFF);
      this.kj = paramAttributeSet.getText(a.j.MenuItem_android_title);
      this.kk = paramAttributeSet.getText(a.j.MenuItem_android_titleCondensed);
      this.kl = paramAttributeSet.getResourceId(a.j.MenuItem_android_icon, 0);
      this.km = q(paramAttributeSet.getString(a.j.MenuItem_android_alphabeticShortcut));
      this.kn = paramAttributeSet.getInt(a.j.MenuItem_alphabeticModifiers, 4096);
      this.ko = q(paramAttributeSet.getString(a.j.MenuItem_android_numericShortcut));
      this.kp = paramAttributeSet.getInt(a.j.MenuItem_numericModifiers, 4096);
      int i;
      if (paramAttributeSet.hasValue(a.j.MenuItem_android_checkable)) {
        if (paramAttributeSet.getBoolean(a.j.MenuItem_android_checkable, false))
        {
          i = 1;
          this.kq = i;
          label188:
          this.kr = paramAttributeSet.getBoolean(a.j.MenuItem_android_checked, false);
          this.ks = paramAttributeSet.getBoolean(a.j.MenuItem_android_visible, this.ke);
          this.kt = paramAttributeSet.getBoolean(a.j.MenuItem_android_enabled, this.kf);
          this.ku = paramAttributeSet.getInt(a.j.MenuItem_showAsAction, -1);
          this.ky = paramAttributeSet.getString(a.j.MenuItem_android_onClick);
          this.kv = paramAttributeSet.getResourceId(a.j.MenuItem_actionLayout, 0);
          this.kw = paramAttributeSet.getString(a.j.MenuItem_actionViewClass);
          this.kx = paramAttributeSet.getString(a.j.MenuItem_actionProviderClass);
          if (this.kx == null) {
            break label443;
          }
          i = j;
          label296:
          if ((i == 0) || (this.kv != 0) || (this.kw != null)) {
            break label448;
          }
          this.kz = ((androidx.core.g.b)newInstance(this.kx, g.jU, g.this.jW));
          label339:
          this.kA = paramAttributeSet.getText(a.j.MenuItem_contentDescription);
          this.kB = paramAttributeSet.getText(a.j.MenuItem_tooltipText);
          if (!paramAttributeSet.hasValue(a.j.MenuItem_iconTintMode)) {
            break label456;
          }
          this.kD = o.c(paramAttributeSet.getInt(a.j.MenuItem_iconTintMode, -1), this.kD);
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
      for (this.kC = paramAttributeSet.getColorStateList(a.j.MenuItem_iconTint);; this.kC = null)
      {
        paramAttributeSet.recycle();
        this.kg = false;
        AppMethodBeat.o(238982);
        return;
        i = 0;
        break;
        this.kq = this.kd;
        break label188;
        i = 0;
        break label296;
        this.kz = null;
        break label339;
        this.kD = null;
        break label390;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.appcompat.view.g
 * JD-Core Version:    0.7.0.1
 */