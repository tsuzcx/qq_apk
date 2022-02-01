package com.tencent.matrix.resource;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.matrix.e.c;
import java.util.ArrayList;

public final class a
{
  private static Pair<ViewGroup, ArrayList<View>> eYX;
  
  /* Error */
  static void cU(View paramView)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: aload_0
    //   6: invokevirtual 15	android/view/View:getContext	()Landroid/content/Context;
    //   9: ifnull -5 -> 4
    //   12: aload_0
    //   13: ifnull +78 -> 91
    //   16: aload_0
    //   17: invokevirtual 19	android/view/View:isClickable	()Z
    //   20: istore_3
    //   21: aload_0
    //   22: invokevirtual 22	android/view/View:isLongClickable	()Z
    //   25: istore 4
    //   27: aload_0
    //   28: aconst_null
    //   29: invokevirtual 26	android/view/View:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   32: aload_0
    //   33: aconst_null
    //   34: invokevirtual 30	android/view/View:setOnCreateContextMenuListener	(Landroid/view/View$OnCreateContextMenuListener;)V
    //   37: aload_0
    //   38: aconst_null
    //   39: invokevirtual 34	android/view/View:setOnFocusChangeListener	(Landroid/view/View$OnFocusChangeListener;)V
    //   42: aload_0
    //   43: aconst_null
    //   44: invokevirtual 38	android/view/View:setOnKeyListener	(Landroid/view/View$OnKeyListener;)V
    //   47: aload_0
    //   48: aconst_null
    //   49: invokevirtual 42	android/view/View:setOnLongClickListener	(Landroid/view/View$OnLongClickListener;)V
    //   52: aload_0
    //   53: aconst_null
    //   54: invokevirtual 26	android/view/View:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   57: aload_0
    //   58: aconst_null
    //   59: invokevirtual 46	android/view/View:setOnTouchListener	(Landroid/view/View$OnTouchListener;)V
    //   62: aload_0
    //   63: invokevirtual 50	android/view/View:getBackground	()Landroid/graphics/drawable/Drawable;
    //   66: ifnull +14 -> 80
    //   69: aload_0
    //   70: new 52	com/tencent/matrix/resource/a$1
    //   73: dup
    //   74: invokespecial 56	com/tencent/matrix/resource/a$1:<init>	()V
    //   77: invokevirtual 60	android/view/View:addOnAttachStateChangeListener	(Landroid/view/View$OnAttachStateChangeListener;)V
    //   80: aload_0
    //   81: iload_3
    //   82: invokevirtual 64	android/view/View:setClickable	(Z)V
    //   85: aload_0
    //   86: iload 4
    //   88: invokevirtual 67	android/view/View:setLongClickable	(Z)V
    //   91: aload_0
    //   92: instanceof 69
    //   95: ifeq +38 -> 133
    //   98: aload_0
    //   99: checkcast 69	android/widget/ImageView
    //   102: astore 5
    //   104: aload 5
    //   106: ifnull +27 -> 133
    //   109: aload 5
    //   111: invokevirtual 72	android/widget/ImageView:getDrawable	()Landroid/graphics/drawable/Drawable;
    //   114: astore 6
    //   116: aload 6
    //   118: ifnull +9 -> 127
    //   121: aload 6
    //   123: aconst_null
    //   124: invokevirtual 78	android/graphics/drawable/Drawable:setCallback	(Landroid/graphics/drawable/Drawable$Callback;)V
    //   127: aload 5
    //   129: aconst_null
    //   130: invokevirtual 82	android/widget/ImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   133: aload_0
    //   134: instanceof 84
    //   137: ifeq +138 -> 275
    //   140: aload_0
    //   141: checkcast 84	android/widget/TextView
    //   144: astore 5
    //   146: aload 5
    //   148: invokevirtual 88	android/widget/TextView:getCompoundDrawables	()[Landroid/graphics/drawable/Drawable;
    //   151: astore 6
    //   153: aload 6
    //   155: arraylength
    //   156: istore_2
    //   157: iconst_0
    //   158: istore_1
    //   159: iload_1
    //   160: iload_2
    //   161: if_icmpge +27 -> 188
    //   164: aload 6
    //   166: iload_1
    //   167: aaload
    //   168: astore 7
    //   170: aload 7
    //   172: ifnull +9 -> 181
    //   175: aload 7
    //   177: aconst_null
    //   178: invokevirtual 78	android/graphics/drawable/Drawable:setCallback	(Landroid/graphics/drawable/Drawable$Callback;)V
    //   181: iload_1
    //   182: iconst_1
    //   183: iadd
    //   184: istore_1
    //   185: goto -26 -> 159
    //   188: aload 5
    //   190: aconst_null
    //   191: aconst_null
    //   192: aconst_null
    //   193: aconst_null
    //   194: invokevirtual 92	android/widget/TextView:setCompoundDrawables	(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V
    //   197: aload 5
    //   199: aconst_null
    //   200: invokevirtual 96	android/widget/TextView:setOnEditorActionListener	(Landroid/widget/TextView$OnEditorActionListener;)V
    //   203: aload 5
    //   205: aconst_null
    //   206: invokevirtual 100	android/widget/TextView:setKeyListener	(Landroid/text/method/KeyListener;)V
    //   209: aload 5
    //   211: aconst_null
    //   212: invokevirtual 104	android/widget/TextView:setMovementMethod	(Landroid/text/method/MovementMethod;)V
    //   215: aload 5
    //   217: instanceof 106
    //   220: ifeq +55 -> 275
    //   223: aload 5
    //   225: ifnull +50 -> 275
    //   228: aload 5
    //   230: ldc 108
    //   232: invokevirtual 112	android/widget/TextView:setHint	(Ljava/lang/CharSequence;)V
    //   235: ldc 84
    //   237: ldc 114
    //   239: invokevirtual 120	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   242: astore 6
    //   244: aload 6
    //   246: iconst_1
    //   247: invokevirtual 125	java/lang/reflect/Field:setAccessible	(Z)V
    //   250: aload 6
    //   252: aload 5
    //   254: invokevirtual 129	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   257: astore 5
    //   259: aload 5
    //   261: instanceof 131
    //   264: ifeq +11 -> 275
    //   267: aload 5
    //   269: checkcast 131	java/util/ArrayList
    //   272: invokevirtual 134	java/util/ArrayList:clear	()V
    //   275: aload_0
    //   276: instanceof 136
    //   279: ifeq +57 -> 336
    //   282: aload_0
    //   283: checkcast 136	android/widget/ProgressBar
    //   286: astore 5
    //   288: aload 5
    //   290: invokevirtual 139	android/widget/ProgressBar:getProgressDrawable	()Landroid/graphics/drawable/Drawable;
    //   293: astore 6
    //   295: aload 6
    //   297: ifnull +15 -> 312
    //   300: aload 5
    //   302: aconst_null
    //   303: invokevirtual 142	android/widget/ProgressBar:setProgressDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   306: aload 6
    //   308: aconst_null
    //   309: invokevirtual 78	android/graphics/drawable/Drawable:setCallback	(Landroid/graphics/drawable/Drawable$Callback;)V
    //   312: aload 5
    //   314: invokevirtual 145	android/widget/ProgressBar:getIndeterminateDrawable	()Landroid/graphics/drawable/Drawable;
    //   317: astore 6
    //   319: aload 6
    //   321: ifnull +15 -> 336
    //   324: aload 5
    //   326: aconst_null
    //   327: invokevirtual 148	android/widget/ProgressBar:setIndeterminateDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   330: aload 6
    //   332: aconst_null
    //   333: invokevirtual 78	android/graphics/drawable/Drawable:setCallback	(Landroid/graphics/drawable/Drawable$Callback;)V
    //   336: aload_0
    //   337: instanceof 150
    //   340: ifeq +65 -> 405
    //   343: aload_0
    //   344: checkcast 150	android/widget/ListView
    //   347: astore 5
    //   349: aload 5
    //   351: invokevirtual 153	android/widget/ListView:getSelector	()Landroid/graphics/drawable/Drawable;
    //   354: astore 6
    //   356: aload 6
    //   358: ifnull +9 -> 367
    //   361: aload 6
    //   363: aconst_null
    //   364: invokevirtual 78	android/graphics/drawable/Drawable:setCallback	(Landroid/graphics/drawable/Drawable$Callback;)V
    //   367: aload 5
    //   369: invokevirtual 157	android/widget/ListView:getAdapter	()Landroid/widget/ListAdapter;
    //   372: ifnull +9 -> 381
    //   375: aload 5
    //   377: aconst_null
    //   378: invokevirtual 161	android/widget/ListView:setAdapter	(Landroid/widget/ListAdapter;)V
    //   381: aload 5
    //   383: aconst_null
    //   384: invokevirtual 165	android/widget/ListView:setOnScrollListener	(Landroid/widget/AbsListView$OnScrollListener;)V
    //   387: aload 5
    //   389: aconst_null
    //   390: invokevirtual 169	android/widget/ListView:setOnItemClickListener	(Landroid/widget/AdapterView$OnItemClickListener;)V
    //   393: aload 5
    //   395: aconst_null
    //   396: invokevirtual 173	android/widget/ListView:setOnItemLongClickListener	(Landroid/widget/AdapterView$OnItemLongClickListener;)V
    //   399: aload 5
    //   401: aconst_null
    //   402: invokevirtual 177	android/widget/ListView:setOnItemSelectedListener	(Landroid/widget/AdapterView$OnItemSelectedListener;)V
    //   405: aload_0
    //   406: instanceof 179
    //   409: ifeq +38 -> 447
    //   412: aload_0
    //   413: checkcast 179	android/widget/FrameLayout
    //   416: astore 5
    //   418: aload 5
    //   420: ifnull +27 -> 447
    //   423: aload 5
    //   425: invokevirtual 182	android/widget/FrameLayout:getForeground	()Landroid/graphics/drawable/Drawable;
    //   428: astore 6
    //   430: aload 6
    //   432: ifnull +15 -> 447
    //   435: aload 6
    //   437: aconst_null
    //   438: invokevirtual 78	android/graphics/drawable/Drawable:setCallback	(Landroid/graphics/drawable/Drawable$Callback;)V
    //   441: aload 5
    //   443: aconst_null
    //   444: invokevirtual 185	android/widget/FrameLayout:setForeground	(Landroid/graphics/drawable/Drawable;)V
    //   447: aload_0
    //   448: instanceof 187
    //   451: ifeq +54 -> 505
    //   454: aload_0
    //   455: checkcast 187	android/widget/LinearLayout
    //   458: astore 6
    //   460: aload 6
    //   462: ifnull +43 -> 505
    //   465: bipush 11
    //   467: getstatic 193	android/os/Build$VERSION:SDK_INT	I
    //   470: if_icmpgt +35 -> 505
    //   473: bipush 16
    //   475: getstatic 193	android/os/Build$VERSION:SDK_INT	I
    //   478: if_icmpgt +66 -> 544
    //   481: aload 6
    //   483: invokevirtual 196	android/widget/LinearLayout:getDividerDrawable	()Landroid/graphics/drawable/Drawable;
    //   486: astore 5
    //   488: aload 5
    //   490: ifnull +15 -> 505
    //   493: aload 5
    //   495: aconst_null
    //   496: invokevirtual 78	android/graphics/drawable/Drawable:setCallback	(Landroid/graphics/drawable/Drawable$Callback;)V
    //   499: aload 6
    //   501: aconst_null
    //   502: invokevirtual 199	android/widget/LinearLayout:setDividerDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   505: aload_0
    //   506: instanceof 201
    //   509: ifeq -505 -> 4
    //   512: aload_0
    //   513: checkcast 201	android/view/ViewGroup
    //   516: astore_0
    //   517: aload_0
    //   518: invokevirtual 205	android/view/ViewGroup:getChildCount	()I
    //   521: istore_2
    //   522: iconst_0
    //   523: istore_1
    //   524: iload_1
    //   525: iload_2
    //   526: if_icmpge -522 -> 4
    //   529: aload_0
    //   530: iload_1
    //   531: invokevirtual 209	android/view/ViewGroup:getChildAt	(I)Landroid/view/View;
    //   534: invokestatic 211	com/tencent/matrix/resource/a:cU	(Landroid/view/View;)V
    //   537: iload_1
    //   538: iconst_1
    //   539: iadd
    //   540: istore_1
    //   541: goto -17 -> 524
    //   544: aload 6
    //   546: invokevirtual 215	java/lang/Object:getClass	()Ljava/lang/Class;
    //   549: ldc 217
    //   551: invokevirtual 120	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   554: astore 5
    //   556: aload 5
    //   558: iconst_1
    //   559: invokevirtual 125	java/lang/reflect/Field:setAccessible	(Z)V
    //   562: aload 5
    //   564: aload 6
    //   566: invokevirtual 129	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   569: checkcast 74	android/graphics/drawable/Drawable
    //   572: astore 5
    //   574: goto -86 -> 488
    //   577: astore 5
    //   579: aconst_null
    //   580: astore 5
    //   582: goto -94 -> 488
    //   585: astore 5
    //   587: goto -555 -> 32
    //   590: astore 5
    //   592: goto -555 -> 37
    //   595: astore 5
    //   597: goto -555 -> 42
    //   600: astore 5
    //   602: goto -555 -> 47
    //   605: astore 5
    //   607: goto -555 -> 52
    //   610: astore 5
    //   612: goto -555 -> 57
    //   615: astore 5
    //   617: goto -555 -> 62
    //   620: astore 6
    //   622: goto -235 -> 387
    //   625: astore 6
    //   627: goto -234 -> 393
    //   630: astore 6
    //   632: goto -233 -> 399
    //   635: astore 5
    //   637: goto -232 -> 405
    //   640: astore 6
    //   642: goto -261 -> 381
    //   645: astore 5
    //   647: goto -372 -> 275
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	650	0	paramView	View
    //   158	383	1	i	int
    //   156	371	2	j	int
    //   20	62	3	bool1	boolean
    //   25	62	4	bool2	boolean
    //   102	471	5	localObject1	Object
    //   577	1	5	localObject2	Object
    //   580	1	5	localObject3	Object
    //   585	1	5	localObject4	Object
    //   590	1	5	localObject5	Object
    //   595	1	5	localObject6	Object
    //   600	1	5	localObject7	Object
    //   605	1	5	localObject8	Object
    //   610	1	5	localObject9	Object
    //   615	1	5	localObject10	Object
    //   635	1	5	localObject11	Object
    //   645	1	5	localObject12	Object
    //   114	451	6	localObject13	Object
    //   620	1	6	localObject14	Object
    //   625	1	6	localObject15	Object
    //   630	1	6	localObject16	Object
    //   640	1	6	localObject17	Object
    //   168	8	7	localObject18	Object
    // Exception table:
    //   from	to	target	type
    //   544	574	577	finally
    //   27	32	585	finally
    //   32	37	590	finally
    //   37	42	595	finally
    //   42	47	600	finally
    //   47	52	605	finally
    //   52	57	610	finally
    //   57	62	615	finally
    //   381	387	620	finally
    //   387	393	625	finally
    //   393	399	630	finally
    //   399	405	635	finally
    //   367	381	640	finally
    //   228	275	645	finally
  }
  
  public static void ch(Context paramContext)
  {
    if (Build.VERSION.SDK_INT != 28) {
      return;
    }
    try
    {
      paramContext = paramContext.getApplicationContext();
      if (eYX == null)
      {
        FrameLayout localFrameLayout = new FrameLayout(paramContext);
        int i = 0;
        while (i < 32)
        {
          localFrameLayout.addView(new View(paramContext));
          i += 1;
        }
        eYX = new Pair(localFrameLayout, new ArrayList());
      }
      ((ViewGroup)eYX.first).addChildrenForAccessibility((ArrayList)eYX.second);
      return;
    }
    finally
    {
      c.printErrStackTrace("Matrix.ActivityLeakFixer", paramContext, "fixViewLocationHolderLeakApi28 err", new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.matrix.resource.a
 * JD-Core Version:    0.7.0.1
 */