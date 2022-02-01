package androidx.core.widget;

import android.content.Intent;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;

final class i$a
  implements ActionMode.Callback
{
  private final ActionMode.Callback QK;
  private Class<?> QL;
  private Method QM;
  private boolean QN;
  private boolean QO;
  private final TextView rR;
  
  i$a(ActionMode.Callback paramCallback, TextView paramTextView)
  {
    this.QK = paramCallback;
    this.rR = paramTextView;
    this.QO = false;
  }
  
  private static Intent hJ()
  {
    AppMethodBeat.i(253158);
    Intent localIntent = new Intent().setAction("android.intent.action.PROCESS_TEXT").setType("text/plain");
    AppMethodBeat.o(253158);
    return localIntent;
  }
  
  public final boolean onActionItemClicked(ActionMode paramActionMode, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(253156);
    boolean bool = this.QK.onActionItemClicked(paramActionMode, paramMenuItem);
    AppMethodBeat.o(253156);
    return bool;
  }
  
  public final boolean onCreateActionMode(ActionMode paramActionMode, Menu paramMenu)
  {
    AppMethodBeat.i(253150);
    boolean bool = this.QK.onCreateActionMode(paramActionMode, paramMenu);
    AppMethodBeat.o(253150);
    return bool;
  }
  
  public final void onDestroyActionMode(ActionMode paramActionMode)
  {
    AppMethodBeat.i(253157);
    this.QK.onDestroyActionMode(paramActionMode);
    AppMethodBeat.o(253157);
  }
  
  /* Error */
  public final boolean onPrepareActionMode(ActionMode paramActionMode, Menu paramMenu)
  {
    // Byte code:
    //   0: ldc 84
    //   2: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 30	androidx/core/widget/i$a:rR	Landroid/widget/TextView;
    //   9: invokevirtual 90	android/widget/TextView:getContext	()Landroid/content/Context;
    //   12: astore 8
    //   14: aload 8
    //   16: invokevirtual 96	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   19: astore 7
    //   21: aload_0
    //   22: getfield 32	androidx/core/widget/i$a:QO	Z
    //   25: ifne +45 -> 70
    //   28: aload_0
    //   29: iconst_1
    //   30: putfield 32	androidx/core/widget/i$a:QO	Z
    //   33: aload_0
    //   34: ldc 98
    //   36: invokestatic 104	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   39: putfield 106	androidx/core/widget/i$a:QL	Ljava/lang/Class;
    //   42: aload_0
    //   43: aload_0
    //   44: getfield 106	androidx/core/widget/i$a:QL	Ljava/lang/Class;
    //   47: ldc 108
    //   49: iconst_1
    //   50: anewarray 100	java/lang/Class
    //   53: dup
    //   54: iconst_0
    //   55: getstatic 113	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   58: aastore
    //   59: invokevirtual 117	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   62: putfield 119	androidx/core/widget/i$a:QM	Ljava/lang/reflect/Method;
    //   65: aload_0
    //   66: iconst_1
    //   67: putfield 121	androidx/core/widget/i$a:QN	Z
    //   70: aload_0
    //   71: getfield 121	androidx/core/widget/i$a:QN	Z
    //   74: ifeq +115 -> 189
    //   77: aload_0
    //   78: getfield 106	androidx/core/widget/i$a:QL	Ljava/lang/Class;
    //   81: aload_2
    //   82: invokevirtual 125	java/lang/Class:isInstance	(Ljava/lang/Object;)Z
    //   85: ifeq +104 -> 189
    //   88: aload_0
    //   89: getfield 119	androidx/core/widget/i$a:QM	Ljava/lang/reflect/Method;
    //   92: astore 6
    //   94: aload_2
    //   95: invokeinterface 131 1 0
    //   100: iconst_1
    //   101: isub
    //   102: istore_3
    //   103: iload_3
    //   104: iflt +109 -> 213
    //   107: aload_2
    //   108: iload_3
    //   109: invokeinterface 135 2 0
    //   114: astore 9
    //   116: aload 9
    //   118: invokeinterface 140 1 0
    //   123: ifnull +39 -> 162
    //   126: ldc 47
    //   128: aload 9
    //   130: invokeinterface 140 1 0
    //   135: invokevirtual 144	android/content/Intent:getAction	()Ljava/lang/String;
    //   138: invokevirtual 149	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   141: ifeq +21 -> 162
    //   144: aload 6
    //   146: aload_2
    //   147: iconst_1
    //   148: anewarray 4	java/lang/Object
    //   151: dup
    //   152: iconst_0
    //   153: iload_3
    //   154: invokestatic 153	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   157: aastore
    //   158: invokevirtual 159	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   161: pop
    //   162: iload_3
    //   163: iconst_1
    //   164: isub
    //   165: istore_3
    //   166: goto -63 -> 103
    //   169: astore 6
    //   171: aload_0
    //   172: aconst_null
    //   173: putfield 106	androidx/core/widget/i$a:QL	Ljava/lang/Class;
    //   176: aload_0
    //   177: aconst_null
    //   178: putfield 119	androidx/core/widget/i$a:QM	Ljava/lang/reflect/Method;
    //   181: aload_0
    //   182: iconst_0
    //   183: putfield 121	androidx/core/widget/i$a:QN	Z
    //   186: goto -116 -> 70
    //   189: aload_2
    //   190: invokevirtual 163	java/lang/Object:getClass	()Ljava/lang/Class;
    //   193: ldc 108
    //   195: iconst_1
    //   196: anewarray 100	java/lang/Class
    //   199: dup
    //   200: iconst_0
    //   201: getstatic 113	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   204: aastore
    //   205: invokevirtual 117	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   208: astore 6
    //   210: goto -116 -> 94
    //   213: new 165	java/util/ArrayList
    //   216: dup
    //   217: invokespecial 166	java/util/ArrayList:<init>	()V
    //   220: astore 6
    //   222: aload 8
    //   224: instanceof 168
    //   227: ifeq +127 -> 354
    //   230: aload 7
    //   232: invokestatic 170	androidx/core/widget/i$a:hJ	()Landroid/content/Intent;
    //   235: iconst_0
    //   236: invokevirtual 176	android/content/pm/PackageManager:queryIntentActivities	(Landroid/content/Intent;I)Ljava/util/List;
    //   239: invokeinterface 182 1 0
    //   244: astore 9
    //   246: aload 9
    //   248: invokeinterface 188 1 0
    //   253: ifeq +101 -> 354
    //   256: aload 9
    //   258: invokeinterface 192 1 0
    //   263: checkcast 194	android/content/pm/ResolveInfo
    //   266: astore 10
    //   268: aload 8
    //   270: invokevirtual 197	android/content/Context:getPackageName	()Ljava/lang/String;
    //   273: aload 10
    //   275: getfield 201	android/content/pm/ResolveInfo:activityInfo	Landroid/content/pm/ActivityInfo;
    //   278: getfield 207	android/content/pm/ActivityInfo:packageName	Ljava/lang/String;
    //   281: invokevirtual 149	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   284: ifeq +22 -> 306
    //   287: iconst_1
    //   288: istore_3
    //   289: iload_3
    //   290: ifeq -44 -> 246
    //   293: aload 6
    //   295: aload 10
    //   297: invokeinterface 210 2 0
    //   302: pop
    //   303: goto -57 -> 246
    //   306: aload 10
    //   308: getfield 201	android/content/pm/ResolveInfo:activityInfo	Landroid/content/pm/ActivityInfo;
    //   311: getfield 213	android/content/pm/ActivityInfo:exported	Z
    //   314: ifeq +35 -> 349
    //   317: aload 10
    //   319: getfield 201	android/content/pm/ResolveInfo:activityInfo	Landroid/content/pm/ActivityInfo;
    //   322: getfield 216	android/content/pm/ActivityInfo:permission	Ljava/lang/String;
    //   325: ifnull +19 -> 344
    //   328: aload 8
    //   330: aload 10
    //   332: getfield 201	android/content/pm/ResolveInfo:activityInfo	Landroid/content/pm/ActivityInfo;
    //   335: getfield 216	android/content/pm/ActivityInfo:permission	Ljava/lang/String;
    //   338: invokevirtual 220	android/content/Context:checkSelfPermission	(Ljava/lang/String;)I
    //   341: ifne +8 -> 349
    //   344: iconst_1
    //   345: istore_3
    //   346: goto -57 -> 289
    //   349: iconst_0
    //   350: istore_3
    //   351: goto -62 -> 289
    //   354: iconst_0
    //   355: istore_3
    //   356: iload_3
    //   357: aload 6
    //   359: invokeinterface 221 1 0
    //   364: if_icmpge +145 -> 509
    //   367: aload 6
    //   369: iload_3
    //   370: invokeinterface 225 2 0
    //   375: checkcast 194	android/content/pm/ResolveInfo
    //   378: astore 8
    //   380: aload_2
    //   381: iconst_0
    //   382: iconst_0
    //   383: iload_3
    //   384: bipush 100
    //   386: iadd
    //   387: aload 8
    //   389: aload 7
    //   391: invokevirtual 229	android/content/pm/ResolveInfo:loadLabel	(Landroid/content/pm/PackageManager;)Ljava/lang/CharSequence;
    //   394: invokeinterface 232 5 0
    //   399: astore 9
    //   401: aload_0
    //   402: getfield 30	androidx/core/widget/i$a:rR	Landroid/widget/TextView;
    //   405: astore 10
    //   407: invokestatic 170	androidx/core/widget/i$a:hJ	()Landroid/content/Intent;
    //   410: astore 11
    //   412: aload 10
    //   414: instanceof 234
    //   417: ifeq +78 -> 495
    //   420: aload 10
    //   422: invokevirtual 237	android/widget/TextView:onCheckIsTextEditor	()Z
    //   425: ifeq +70 -> 495
    //   428: aload 10
    //   430: invokevirtual 240	android/widget/TextView:isEnabled	()Z
    //   433: ifeq +62 -> 495
    //   436: iconst_1
    //   437: istore 4
    //   439: iload 4
    //   441: ifne +60 -> 501
    //   444: iconst_1
    //   445: istore 5
    //   447: aload 9
    //   449: aload 11
    //   451: ldc 242
    //   453: iload 5
    //   455: invokevirtual 246	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   458: aload 8
    //   460: getfield 201	android/content/pm/ResolveInfo:activityInfo	Landroid/content/pm/ActivityInfo;
    //   463: getfield 207	android/content/pm/ActivityInfo:packageName	Ljava/lang/String;
    //   466: aload 8
    //   468: getfield 201	android/content/pm/ResolveInfo:activityInfo	Landroid/content/pm/ActivityInfo;
    //   471: getfield 249	android/content/pm/ActivityInfo:name	Ljava/lang/String;
    //   474: invokevirtual 253	android/content/Intent:setClassName	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   477: invokeinterface 257 2 0
    //   482: iconst_1
    //   483: invokeinterface 260 2 0
    //   488: iload_3
    //   489: iconst_1
    //   490: iadd
    //   491: istore_3
    //   492: goto -136 -> 356
    //   495: iconst_0
    //   496: istore 4
    //   498: goto -59 -> 439
    //   501: iconst_0
    //   502: istore 5
    //   504: goto -57 -> 447
    //   507: astore 6
    //   509: aload_0
    //   510: getfield 28	androidx/core/widget/i$a:QK	Landroid/view/ActionMode$Callback;
    //   513: aload_1
    //   514: aload_2
    //   515: invokeinterface 262 3 0
    //   520: istore 5
    //   522: ldc 84
    //   524: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   527: iload 5
    //   529: ireturn
    //   530: astore 6
    //   532: goto -23 -> 509
    //   535: astore 6
    //   537: goto -28 -> 509
    //   540: astore 6
    //   542: goto -371 -> 171
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	545	0	this	a
    //   0	545	1	paramActionMode	ActionMode
    //   0	545	2	paramMenu	Menu
    //   102	390	3	i	int
    //   437	60	4	j	int
    //   445	83	5	bool	boolean
    //   92	53	6	localMethod	Method
    //   169	1	6	localClassNotFoundException	java.lang.ClassNotFoundException
    //   208	160	6	localObject1	Object
    //   507	1	6	localIllegalAccessException	java.lang.IllegalAccessException
    //   530	1	6	localNoSuchMethodException1	java.lang.NoSuchMethodException
    //   535	1	6	localInvocationTargetException	java.lang.reflect.InvocationTargetException
    //   540	1	6	localNoSuchMethodException2	java.lang.NoSuchMethodException
    //   19	371	7	localPackageManager	android.content.pm.PackageManager
    //   12	455	8	localObject2	Object
    //   114	334	9	localObject3	Object
    //   266	163	10	localObject4	Object
    //   410	40	11	localIntent	Intent
    // Exception table:
    //   from	to	target	type
    //   33	70	169	java/lang/ClassNotFoundException
    //   70	94	507	java/lang/IllegalAccessException
    //   94	103	507	java/lang/IllegalAccessException
    //   107	162	507	java/lang/IllegalAccessException
    //   189	210	507	java/lang/IllegalAccessException
    //   70	94	530	java/lang/NoSuchMethodException
    //   94	103	530	java/lang/NoSuchMethodException
    //   107	162	530	java/lang/NoSuchMethodException
    //   189	210	530	java/lang/NoSuchMethodException
    //   70	94	535	java/lang/reflect/InvocationTargetException
    //   94	103	535	java/lang/reflect/InvocationTargetException
    //   107	162	535	java/lang/reflect/InvocationTargetException
    //   189	210	535	java/lang/reflect/InvocationTargetException
    //   33	70	540	java/lang/NoSuchMethodException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     androidx.core.widget.i.a
 * JD-Core Version:    0.7.0.1
 */