package android.support.v7.view;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.os.Build.VERSION;
import android.support.v7.a.a.a;
import android.support.v7.view.menu.j;
import android.support.v7.view.menu.k;
import android.support.v7.widget.x;
import android.util.AttributeSet;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;

public final class g
  extends MenuInflater
{
  static final Class<?>[] adM;
  static final Class<?>[] adN;
  final Object[] adO;
  final Object[] adP;
  Object adQ;
  Context mContext;
  
  static
  {
    Class[] arrayOfClass = new Class[1];
    arrayOfClass[0] = Context.class;
    adM = arrayOfClass;
    adN = arrayOfClass;
  }
  
  public g(Context paramContext)
  {
    super(paramContext);
    this.mContext = paramContext;
    this.adO = new Object[] { paramContext };
    this.adP = this.adO;
  }
  
  static Object N(Object paramObject)
  {
    for (;;)
    {
      if ((paramObject instanceof Activity)) {}
      while (!(paramObject instanceof ContextWrapper)) {
        return paramObject;
      }
      paramObject = ((ContextWrapper)paramObject).getBaseContext();
    }
  }
  
  private void a(XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Menu paramMenu)
  {
    b localb = new b(paramMenu);
    int i = paramXmlPullParser.getEventType();
    label49:
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
        label65:
        if (i != 0) {
          return;
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
        break label65;
        throw new RuntimeException("Expecting menu, got ".concat(String.valueOf(paramMenu)));
        j = paramXmlPullParser.next();
        i = j;
        if (j != 1) {
          break;
        }
        i = j;
        break label49;
        if (j == 0)
        {
          String str = paramXmlPullParser.getName();
          if (str.equals("group"))
          {
            localb.c(paramAttributeSet);
          }
          else if (str.equals("item"))
          {
            localb.d(paramAttributeSet);
          }
          else if (str.equals("menu"))
          {
            a(paramXmlPullParser, paramAttributeSet, localb.hH());
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
              localb.hF();
            }
            else if (str.equals("item"))
            {
              if (!localb.adZ) {
                if ((localb.aes != null) && (localb.aes.hasSubMenu())) {
                  localb.hH();
                } else {
                  localb.hG();
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
    throw new RuntimeException("Unexpected end of document");
  }
  
  /* Error */
  public final void inflate(int paramInt, Menu paramMenu)
  {
    // Byte code:
    //   0: aload_2
    //   1: instanceof 141
    //   4: ifne +10 -> 14
    //   7: aload_0
    //   8: iload_1
    //   9: aload_2
    //   10: invokespecial 143	android/view/MenuInflater:inflate	(ILandroid/view/Menu;)V
    //   13: return
    //   14: aconst_null
    //   15: astore_3
    //   16: aconst_null
    //   17: astore 5
    //   19: aconst_null
    //   20: astore 4
    //   22: aload_0
    //   23: getfield 38	android/support/v7/view/g:mContext	Landroid/content/Context;
    //   26: invokevirtual 147	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   29: iload_1
    //   30: invokevirtual 153	android/content/res/Resources:getLayout	(I)Landroid/content/res/XmlResourceParser;
    //   33: astore 6
    //   35: aload 6
    //   37: astore 4
    //   39: aload 6
    //   41: astore_3
    //   42: aload 6
    //   44: astore 5
    //   46: aload_0
    //   47: aload 6
    //   49: aload 6
    //   51: invokestatic 159	android/util/Xml:asAttributeSet	(Lorg/xmlpull/v1/XmlPullParser;)Landroid/util/AttributeSet;
    //   54: aload_2
    //   55: invokespecial 111	android/support/v7/view/g:a	(Lorg/xmlpull/v1/XmlPullParser;Landroid/util/AttributeSet;Landroid/view/Menu;)V
    //   58: aload 6
    //   60: ifnull -47 -> 13
    //   63: aload 6
    //   65: invokeinterface 164 1 0
    //   70: return
    //   71: astore_2
    //   72: aload 4
    //   74: astore_3
    //   75: new 166	android/view/InflateException
    //   78: dup
    //   79: ldc 168
    //   81: aload_2
    //   82: invokespecial 171	android/view/InflateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   85: athrow
    //   86: astore_2
    //   87: aload_3
    //   88: ifnull +9 -> 97
    //   91: aload_3
    //   92: invokeinterface 164 1 0
    //   97: aload_2
    //   98: athrow
    //   99: astore_2
    //   100: aload 5
    //   102: astore_3
    //   103: new 166	android/view/InflateException
    //   106: dup
    //   107: ldc 168
    //   109: aload_2
    //   110: invokespecial 171	android/view/InflateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   113: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	114	0	this	g
    //   0	114	1	paramInt	int
    //   0	114	2	paramMenu	Menu
    //   15	88	3	localObject1	Object
    //   20	53	4	localObject2	Object
    //   17	84	5	localObject3	Object
    //   33	31	6	localXmlResourceParser	android.content.res.XmlResourceParser
    // Exception table:
    //   from	to	target	type
    //   22	35	71	org/xmlpull/v1/XmlPullParserException
    //   46	58	71	org/xmlpull/v1/XmlPullParserException
    //   22	35	86	finally
    //   46	58	86	finally
    //   75	86	86	finally
    //   103	114	86	finally
    //   22	35	99	java/io/IOException
    //   46	58	99	java/io/IOException
  }
  
  static final class a
    implements MenuItem.OnMenuItemClickListener
  {
    private static final Class<?>[] adR = { MenuItem.class };
    private Object adQ;
    private Method mMethod;
    
    public a(Object paramObject, String paramString)
    {
      this.adQ = paramObject;
      Class localClass = paramObject.getClass();
      try
      {
        this.mMethod = localClass.getMethod(paramString, adR);
        return;
      }
      catch (Exception paramObject)
      {
        paramString = new InflateException("Couldn't resolve menu item onClick handler " + paramString + " in class " + localClass.getName());
        paramString.initCause(paramObject);
        throw paramString;
      }
    }
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      try
      {
        if (this.mMethod.getReturnType() == Boolean.TYPE) {
          return ((Boolean)this.mMethod.invoke(this.adQ, new Object[] { paramMenuItem })).booleanValue();
        }
        this.mMethod.invoke(this.adQ, new Object[] { paramMenuItem });
        return true;
      }
      catch (Exception paramMenuItem)
      {
        throw new RuntimeException(paramMenuItem);
      }
    }
  }
  
  final class b
  {
    private Menu adS;
    private int adT;
    private int adU;
    private int adV;
    private int adW;
    private boolean adX;
    private boolean adY;
    boolean adZ;
    private int aea;
    private int aeb;
    private CharSequence aec;
    private CharSequence aed;
    private int aee;
    private char aef;
    private int aeg;
    private char aeh;
    private int aei;
    private int aej;
    private boolean aek;
    private boolean ael;
    private boolean aem;
    private int aen;
    private int aeo;
    private String aep;
    private String aeq;
    private String aer;
    android.support.v4.view.b aes;
    private CharSequence aet;
    private CharSequence aeu;
    private ColorStateList aev = null;
    private PorterDuff.Mode aew = null;
    
    public b(Menu paramMenu)
    {
      this.adS = paramMenu;
      hF();
    }
    
    private static char D(String paramString)
    {
      if (paramString == null) {
        return '\000';
      }
      return paramString.charAt(0);
    }
    
    private void a(MenuItem paramMenuItem)
    {
      int i = 1;
      Object localObject = paramMenuItem.setChecked(this.aek).setVisible(this.ael).setEnabled(this.aem);
      if (this.aej > 0) {}
      for (boolean bool = true;; bool = false)
      {
        ((MenuItem)localObject).setCheckable(bool).setTitleCondensed(this.aed).setIcon(this.aee);
        if (this.aen >= 0) {
          paramMenuItem.setShowAsAction(this.aen);
        }
        if (this.aer == null) {
          break label173;
        }
        if (!g.this.mContext.isRestricted()) {
          break;
        }
        throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
      }
      localObject = g.this;
      if (((g)localObject).adQ == null) {
        ((g)localObject).adQ = g.N(((g)localObject).mContext);
      }
      paramMenuItem.setOnMenuItemClickListener(new g.a(((g)localObject).adQ, this.aer));
      label173:
      if (this.aej >= 2)
      {
        if (!(paramMenuItem instanceof j)) {
          break label458;
        }
        ((j)paramMenuItem).ab(true);
      }
      else
      {
        if (this.aep == null) {
          break label660;
        }
        paramMenuItem.setActionView((View)newInstance(this.aep, g.adM, g.this.adO));
      }
      for (;;)
      {
        if ((this.aeo > 0) && (i == 0)) {
          paramMenuItem.setActionView(this.aeo);
        }
        if (this.aes != null)
        {
          localObject = this.aes;
          if ((paramMenuItem instanceof android.support.v4.a.a.b)) {
            ((android.support.v4.a.a.b)paramMenuItem).a((android.support.v4.view.b)localObject);
          }
        }
        localObject = this.aet;
        label310:
        label335:
        char c;
        if ((paramMenuItem instanceof android.support.v4.a.a.b))
        {
          ((android.support.v4.a.a.b)paramMenuItem).k((CharSequence)localObject);
          localObject = this.aeu;
          if (!(paramMenuItem instanceof android.support.v4.a.a.b)) {
            break label562;
          }
          ((android.support.v4.a.a.b)paramMenuItem).l((CharSequence)localObject);
          c = this.aef;
          i = this.aeg;
          if (!(paramMenuItem instanceof android.support.v4.a.a.b)) {
            break label582;
          }
          ((android.support.v4.a.a.b)paramMenuItem).setAlphabeticShortcut(c, i);
          label364:
          c = this.aeh;
          i = this.aei;
          if (!(paramMenuItem instanceof android.support.v4.a.a.b)) {
            break label602;
          }
          ((android.support.v4.a.a.b)paramMenuItem).setNumericShortcut(c, i);
          label393:
          if (this.aew != null)
          {
            localObject = this.aew;
            if (!(paramMenuItem instanceof android.support.v4.a.a.b)) {
              break label622;
            }
            ((android.support.v4.a.a.b)paramMenuItem).setIconTintMode((PorterDuff.Mode)localObject);
          }
        }
        for (;;)
        {
          for (;;)
          {
            if (this.aev != null)
            {
              localObject = this.aev;
              if (!(paramMenuItem instanceof android.support.v4.a.a.b)) {
                break label642;
              }
              ((android.support.v4.a.a.b)paramMenuItem).setIconTintList((ColorStateList)localObject);
            }
            return;
            label458:
            if (!(paramMenuItem instanceof k)) {
              break;
            }
            localObject = (k)paramMenuItem;
            try
            {
              if (((k)localObject).agX == null) {
                ((k)localObject).agX = ((android.support.v4.a.a.b)((k)localObject).afm).getClass().getDeclaredMethod("setExclusiveCheckable", new Class[] { Boolean.TYPE });
              }
              ((k)localObject).agX.invoke(((k)localObject).afm, new Object[] { Boolean.TRUE });
            }
            catch (Exception localException) {}
          }
          break;
          if (Build.VERSION.SDK_INT < 26) {
            break label310;
          }
          paramMenuItem.setContentDescription(localException);
          break label310;
          label562:
          if (Build.VERSION.SDK_INT < 26) {
            break label335;
          }
          paramMenuItem.setTooltipText(localException);
          break label335;
          label582:
          if (Build.VERSION.SDK_INT < 26) {
            break label364;
          }
          paramMenuItem.setAlphabeticShortcut(c, i);
          break label364;
          label602:
          if (Build.VERSION.SDK_INT < 26) {
            break label393;
          }
          paramMenuItem.setNumericShortcut(c, i);
          break label393;
          label622:
          if (Build.VERSION.SDK_INT >= 26) {
            paramMenuItem.setIconTintMode(localException);
          }
        }
        label642:
        if (Build.VERSION.SDK_INT < 26) {
          break;
        }
        paramMenuItem.setIconTintList(localException);
        return;
        label660:
        i = 0;
      }
    }
    
    private <T> T newInstance(String paramString, Class<?>[] paramArrayOfClass, Object[] paramArrayOfObject)
    {
      try
      {
        paramString = g.this.mContext.getClassLoader().loadClass(paramString).getConstructor(paramArrayOfClass);
        paramString.setAccessible(true);
        paramString = paramString.newInstance(paramArrayOfObject);
        return paramString;
      }
      catch (Exception paramString) {}
      return null;
    }
    
    public final void c(AttributeSet paramAttributeSet)
    {
      paramAttributeSet = g.this.mContext.obtainStyledAttributes(paramAttributeSet, a.a.MenuGroup);
      this.adT = paramAttributeSet.getResourceId(1, 0);
      this.adU = paramAttributeSet.getInt(3, 0);
      this.adV = paramAttributeSet.getInt(4, 0);
      this.adW = paramAttributeSet.getInt(5, 0);
      this.adX = paramAttributeSet.getBoolean(2, true);
      this.adY = paramAttributeSet.getBoolean(0, true);
      paramAttributeSet.recycle();
    }
    
    public final void d(AttributeSet paramAttributeSet)
    {
      int j = 1;
      paramAttributeSet = g.this.mContext.obtainStyledAttributes(paramAttributeSet, a.a.MenuItem);
      this.aea = paramAttributeSet.getResourceId(2, 0);
      this.aeb = (paramAttributeSet.getInt(5, this.adU) & 0xFFFF0000 | paramAttributeSet.getInt(6, this.adV) & 0xFFFF);
      this.aec = paramAttributeSet.getText(7);
      this.aed = paramAttributeSet.getText(8);
      this.aee = paramAttributeSet.getResourceId(0, 0);
      this.aef = D(paramAttributeSet.getString(9));
      this.aeg = paramAttributeSet.getInt(16, 4096);
      this.aeh = D(paramAttributeSet.getString(10));
      this.aei = paramAttributeSet.getInt(20, 4096);
      int i;
      if (paramAttributeSet.hasValue(11)) {
        if (paramAttributeSet.getBoolean(11, false))
        {
          i = 1;
          this.aej = i;
          label167:
          this.aek = paramAttributeSet.getBoolean(3, false);
          this.ael = paramAttributeSet.getBoolean(4, this.adX);
          this.aem = paramAttributeSet.getBoolean(1, this.adY);
          this.aen = paramAttributeSet.getInt(21, -1);
          this.aer = paramAttributeSet.getString(12);
          this.aeo = paramAttributeSet.getResourceId(13, 0);
          this.aep = paramAttributeSet.getString(15);
          this.aeq = paramAttributeSet.getString(14);
          if (this.aeq == null) {
            break label399;
          }
          i = j;
          label264:
          if ((i == 0) || (this.aeo != 0) || (this.aep != null)) {
            break label404;
          }
          this.aes = ((android.support.v4.view.b)newInstance(this.aeq, g.adN, g.this.adP));
          label307:
          this.aet = paramAttributeSet.getText(17);
          this.aeu = paramAttributeSet.getText(22);
          if (!paramAttributeSet.hasValue(19)) {
            break label412;
          }
          this.aew = x.a(paramAttributeSet.getInt(19, -1), this.aew);
          label354:
          if (!paramAttributeSet.hasValue(18)) {
            break label420;
          }
        }
      }
      label399:
      label404:
      label412:
      label420:
      for (this.aev = paramAttributeSet.getColorStateList(18);; this.aev = null)
      {
        paramAttributeSet.recycle();
        this.adZ = false;
        return;
        i = 0;
        break;
        this.aej = this.adW;
        break label167;
        i = 0;
        break label264;
        this.aes = null;
        break label307;
        this.aew = null;
        break label354;
      }
    }
    
    public final void hF()
    {
      this.adT = 0;
      this.adU = 0;
      this.adV = 0;
      this.adW = 0;
      this.adX = true;
      this.adY = true;
    }
    
    public final void hG()
    {
      this.adZ = true;
      a(this.adS.add(this.adT, this.aea, this.aeb, this.aec));
    }
    
    public final SubMenu hH()
    {
      this.adZ = true;
      SubMenu localSubMenu = this.adS.addSubMenu(this.adT, this.aea, this.aeb, this.aec);
      a(localSubMenu.getItem());
      return localSubMenu;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.view.g
 * JD-Core Version:    0.7.0.1
 */