package android.support.v7.view;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.support.v4.view.f;
import android.support.v7.a.a.j;
import android.support.v7.view.menu.j;
import android.support.v7.view.menu.k;
import android.support.v7.widget.y;
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
  static final Class<?>[] Ta;
  static final Class<?>[] Tb;
  final Object[] Tc;
  final Object[] Td;
  Object Te;
  Context mContext;
  
  static
  {
    Class[] arrayOfClass = new Class[1];
    arrayOfClass[0] = Context.class;
    Ta = arrayOfClass;
    Tb = arrayOfClass;
  }
  
  public g(Context paramContext)
  {
    super(paramContext);
    this.mContext = paramContext;
    this.Tc = new Object[] { paramContext };
    this.Td = this.Tc;
  }
  
  static Object L(Object paramObject)
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
    int k = 0;
    paramMenu = null;
    Object localObject;
    label56:
    int j;
    if (i == 2)
    {
      localObject = paramXmlPullParser.getName();
      if (((String)localObject).equals("menu"))
      {
        i = paramXmlPullParser.next();
        int m = 0;
        j = k;
        k = i;
        i = m;
        label71:
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
        break label71;
        throw new RuntimeException("Expecting menu, got " + (String)localObject);
        j = paramXmlPullParser.next();
        i = j;
        if (j != 1) {
          break;
        }
        i = j;
        break label56;
        if (j == 0)
        {
          localObject = paramXmlPullParser.getName();
          if (((String)localObject).equals("group"))
          {
            localObject = localb.TL.mContext.obtainStyledAttributes(paramAttributeSet, a.j.MenuGroup);
            localb.Th = ((TypedArray)localObject).getResourceId(a.j.MenuGroup_android_id, 0);
            localb.Ti = ((TypedArray)localObject).getInt(a.j.MenuGroup_android_menuCategory, 0);
            localb.Tj = ((TypedArray)localObject).getInt(a.j.MenuGroup_android_orderInCategory, 0);
            localb.Tk = ((TypedArray)localObject).getInt(a.j.MenuGroup_android_checkableBehavior, 0);
            localb.Tl = ((TypedArray)localObject).getBoolean(a.j.MenuGroup_android_visible, true);
            localb.Tm = ((TypedArray)localObject).getBoolean(a.j.MenuGroup_android_enabled, true);
            ((TypedArray)localObject).recycle();
          }
          else
          {
            if (((String)localObject).equals("item"))
            {
              localObject = localb.TL.mContext.obtainStyledAttributes(paramAttributeSet, a.j.MenuItem);
              localb.To = ((TypedArray)localObject).getResourceId(a.j.MenuItem_android_id, 0);
              localb.Tp = (((TypedArray)localObject).getInt(a.j.MenuItem_android_menuCategory, localb.Ti) & 0xFFFF0000 | ((TypedArray)localObject).getInt(a.j.MenuItem_android_orderInCategory, localb.Tj) & 0xFFFF);
              localb.Tq = ((TypedArray)localObject).getText(a.j.MenuItem_android_title);
              localb.Tr = ((TypedArray)localObject).getText(a.j.MenuItem_android_titleCondensed);
              localb.Ts = ((TypedArray)localObject).getResourceId(a.j.MenuItem_android_icon, 0);
              localb.Tt = b.O(((TypedArray)localObject).getString(a.j.MenuItem_android_alphabeticShortcut));
              localb.Tu = ((TypedArray)localObject).getInt(a.j.MenuItem_alphabeticModifiers, 4096);
              localb.Tv = b.O(((TypedArray)localObject).getString(a.j.MenuItem_android_numericShortcut));
              localb.Tw = ((TypedArray)localObject).getInt(a.j.MenuItem_numericModifiers, 4096);
              if (((TypedArray)localObject).hasValue(a.j.MenuItem_android_checkable)) {
                if (((TypedArray)localObject).getBoolean(a.j.MenuItem_android_checkable, false))
                {
                  k = 1;
                  label506:
                  localb.Tx = k;
                  label513:
                  localb.Ty = ((TypedArray)localObject).getBoolean(a.j.MenuItem_android_checked, false);
                  localb.Tz = ((TypedArray)localObject).getBoolean(a.j.MenuItem_android_visible, localb.Tl);
                  localb.TA = ((TypedArray)localObject).getBoolean(a.j.MenuItem_android_enabled, localb.Tm);
                  localb.TB = ((TypedArray)localObject).getInt(a.j.MenuItem_showAsAction, -1);
                  localb.TF = ((TypedArray)localObject).getString(a.j.MenuItem_android_onClick);
                  localb.TC = ((TypedArray)localObject).getResourceId(a.j.MenuItem_actionLayout, 0);
                  localb.TD = ((TypedArray)localObject).getString(a.j.MenuItem_actionViewClass);
                  localb.TE = ((TypedArray)localObject).getString(a.j.MenuItem_actionProviderClass);
                  if (localb.TE == null) {
                    break label807;
                  }
                  k = 1;
                  label641:
                  if ((k == 0) || (localb.TC != 0) || (localb.TD != null)) {
                    break label813;
                  }
                  localb.TG = ((android.support.v4.view.b)localb.newInstance(localb.TE, Tb, localb.TL.Td));
                  label691:
                  localb.TH = ((TypedArray)localObject).getText(a.j.MenuItem_contentDescription);
                  localb.TI = ((TypedArray)localObject).getText(a.j.MenuItem_tooltipText);
                  if (!((TypedArray)localObject).hasValue(a.j.MenuItem_iconTintMode)) {
                    break label822;
                  }
                  localb.TK = y.c(((TypedArray)localObject).getInt(a.j.MenuItem_iconTintMode, -1), localb.TK);
                  label750:
                  if (!((TypedArray)localObject).hasValue(a.j.MenuItem_iconTint)) {
                    break label831;
                  }
                }
              }
              label807:
              label813:
              label822:
              label831:
              for (localb.TJ = ((TypedArray)localObject).getColorStateList(a.j.MenuItem_iconTint);; localb.TJ = null)
              {
                ((TypedArray)localObject).recycle();
                localb.Tn = false;
                break;
                k = 0;
                break label506;
                localb.Tx = localb.Tk;
                break label513;
                k = 0;
                break label641;
                localb.TG = null;
                break label691;
                localb.TK = null;
                break label750;
              }
            }
            if (((String)localObject).equals("menu"))
            {
              a(paramXmlPullParser, paramAttributeSet, localb.eQ());
            }
            else
            {
              j = 1;
              paramMenu = (Menu)localObject;
              continue;
              localObject = paramXmlPullParser.getName();
              if ((j != 0) && (((String)localObject).equals(paramMenu)))
              {
                paramMenu = null;
                j = 0;
              }
              else if (((String)localObject).equals("group"))
              {
                localb.eP();
              }
              else if (((String)localObject).equals("item"))
              {
                if (!localb.Tn) {
                  if ((localb.TG != null) && (localb.TG.hasSubMenu()))
                  {
                    localb.eQ();
                  }
                  else
                  {
                    localb.Tn = true;
                    localb.d(localb.Tg.add(localb.Th, localb.To, localb.Tp, localb.Tq));
                  }
                }
              }
              else if (((String)localObject).equals("menu"))
              {
                i = 1;
              }
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
    //   1: instanceof 389
    //   4: ifne +10 -> 14
    //   7: aload_0
    //   8: iload_1
    //   9: aload_2
    //   10: invokespecial 391	android/view/MenuInflater:inflate	(ILandroid/view/Menu;)V
    //   13: return
    //   14: aconst_null
    //   15: astore_3
    //   16: aconst_null
    //   17: astore 5
    //   19: aconst_null
    //   20: astore 4
    //   22: aload_0
    //   23: getfield 38	android/support/v7/view/g:mContext	Landroid/content/Context;
    //   26: invokevirtual 395	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   29: iload_1
    //   30: invokevirtual 401	android/content/res/Resources:getLayout	(I)Landroid/content/res/XmlResourceParser;
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
    //   51: invokestatic 407	android/util/Xml:asAttributeSet	(Lorg/xmlpull/v1/XmlPullParser;)Landroid/util/AttributeSet;
    //   54: aload_2
    //   55: invokespecial 358	android/support/v7/view/g:a	(Lorg/xmlpull/v1/XmlPullParser;Landroid/util/AttributeSet;Landroid/view/Menu;)V
    //   58: aload 6
    //   60: ifnull -47 -> 13
    //   63: aload 6
    //   65: invokeinterface 412 1 0
    //   70: return
    //   71: astore_2
    //   72: aload 4
    //   74: astore_3
    //   75: new 414	android/view/InflateException
    //   78: dup
    //   79: ldc_w 416
    //   82: aload_2
    //   83: invokespecial 419	android/view/InflateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   86: athrow
    //   87: astore_2
    //   88: aload_3
    //   89: ifnull +9 -> 98
    //   92: aload_3
    //   93: invokeinterface 412 1 0
    //   98: aload_2
    //   99: athrow
    //   100: astore_2
    //   101: aload 5
    //   103: astore_3
    //   104: new 414	android/view/InflateException
    //   107: dup
    //   108: ldc_w 416
    //   111: aload_2
    //   112: invokespecial 419	android/view/InflateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   115: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	116	0	this	g
    //   0	116	1	paramInt	int
    //   0	116	2	paramMenu	Menu
    //   15	89	3	localObject1	Object
    //   20	53	4	localObject2	Object
    //   17	85	5	localObject3	Object
    //   33	31	6	localXmlResourceParser	android.content.res.XmlResourceParser
    // Exception table:
    //   from	to	target	type
    //   22	35	71	org/xmlpull/v1/XmlPullParserException
    //   46	58	71	org/xmlpull/v1/XmlPullParserException
    //   22	35	87	finally
    //   46	58	87	finally
    //   75	87	87	finally
    //   104	116	87	finally
    //   22	35	100	java/io/IOException
    //   46	58	100	java/io/IOException
  }
  
  private static final class a
    implements MenuItem.OnMenuItemClickListener
  {
    private static final Class<?>[] Tf = { MenuItem.class };
    private Object Te;
    private Method mMethod;
    
    public a(Object paramObject, String paramString)
    {
      this.Te = paramObject;
      Class localClass = paramObject.getClass();
      try
      {
        this.mMethod = localClass.getMethod(paramString, Tf);
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
          return ((Boolean)this.mMethod.invoke(this.Te, new Object[] { paramMenuItem })).booleanValue();
        }
        this.mMethod.invoke(this.Te, new Object[] { paramMenuItem });
        return true;
      }
      catch (Exception paramMenuItem)
      {
        throw new RuntimeException(paramMenuItem);
      }
    }
  }
  
  private final class b
  {
    boolean TA;
    int TB;
    int TC;
    String TD;
    String TE;
    String TF;
    android.support.v4.view.b TG;
    CharSequence TH;
    CharSequence TI;
    ColorStateList TJ = null;
    PorterDuff.Mode TK = null;
    Menu Tg;
    int Th;
    int Ti;
    int Tj;
    int Tk;
    boolean Tl;
    boolean Tm;
    boolean Tn;
    int To;
    int Tp;
    CharSequence Tq;
    CharSequence Tr;
    int Ts;
    char Tt;
    int Tu;
    char Tv;
    int Tw;
    int Tx;
    boolean Ty;
    boolean Tz;
    
    public b(Menu paramMenu)
    {
      this.Tg = paramMenu;
      eP();
    }
    
    static char O(String paramString)
    {
      if (paramString == null) {
        return '\000';
      }
      return paramString.charAt(0);
    }
    
    final void d(MenuItem paramMenuItem)
    {
      int i = 1;
      Object localObject = paramMenuItem.setChecked(this.Ty).setVisible(this.Tz).setEnabled(this.TA);
      if (this.Tx > 0) {}
      for (boolean bool = true;; bool = false)
      {
        ((MenuItem)localObject).setCheckable(bool).setTitleCondensed(this.Tr).setIcon(this.Ts);
        if (this.TB >= 0) {
          paramMenuItem.setShowAsAction(this.TB);
        }
        if (this.TF == null) {
          break label170;
        }
        if (!g.this.mContext.isRestricted()) {
          break;
        }
        throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
      }
      localObject = g.this;
      if (((g)localObject).Te == null) {
        ((g)localObject).Te = g.L(((g)localObject).mContext);
      }
      paramMenuItem.setOnMenuItemClickListener(new g.a(((g)localObject).Te, this.TF));
      label170:
      if (this.Tx >= 2)
      {
        if ((paramMenuItem instanceof j)) {
          ((j)paramMenuItem).U(true);
        }
      }
      else
      {
        if (this.TD == null) {
          break label422;
        }
        paramMenuItem.setActionView((View)newInstance(this.TD, g.Ta, g.this.Tc));
      }
      for (;;)
      {
        for (;;)
        {
          if ((this.TC > 0) && (i == 0)) {
            paramMenuItem.setActionView(this.TC);
          }
          if (this.TG != null) {
            f.a(paramMenuItem, this.TG);
          }
          f.a(paramMenuItem, this.TH);
          f.b(paramMenuItem, this.TI);
          f.b(paramMenuItem, this.Tt, this.Tu);
          f.a(paramMenuItem, this.Tv, this.Tw);
          if (this.TK != null) {
            f.a(paramMenuItem, this.TK);
          }
          if (this.TJ != null) {
            f.a(paramMenuItem, this.TJ);
          }
          return;
          if (!(paramMenuItem instanceof k)) {
            break;
          }
          localObject = (k)paramMenuItem;
          try
          {
            if (((k)localObject).Wh == null) {
              ((k)localObject).Wh = ((android.support.v4.b.a.b)((k)localObject).mWrappedObject).getClass().getDeclaredMethod("setExclusiveCheckable", new Class[] { Boolean.TYPE });
            }
            ((k)localObject).Wh.invoke(((k)localObject).mWrappedObject, new Object[] { Boolean.valueOf(true) });
          }
          catch (Exception localException) {}
        }
        break;
        label422:
        i = 0;
      }
    }
    
    public final void eP()
    {
      this.Th = 0;
      this.Ti = 0;
      this.Tj = 0;
      this.Tk = 0;
      this.Tl = true;
      this.Tm = true;
    }
    
    public final SubMenu eQ()
    {
      this.Tn = true;
      SubMenu localSubMenu = this.Tg.addSubMenu(this.Th, this.To, this.Tp, this.Tq);
      d(localSubMenu.getItem());
      return localSubMenu;
    }
    
    final <T> T newInstance(String paramString, Class<?>[] paramArrayOfClass, Object[] paramArrayOfObject)
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
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.view.g
 * JD-Core Version:    0.7.0.1
 */