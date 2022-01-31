package android.support.constraint.solver.widgets;

import android.support.constraint.solver.LinearSystem;
import android.support.constraint.solver.Metrics;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConstraintWidgetContainer
  extends WidgetContainer
{
  private static final boolean DEBUG = false;
  static final boolean DEBUG_GRAPH = false;
  private static final boolean DEBUG_LAYOUT = false;
  private static final int MAX_ITERATIONS = 8;
  private static final boolean USE_SNAPSHOT = true;
  int mDebugSolverPassCount = 0;
  public boolean mGroupsWrapOptimized = false;
  private boolean mHeightMeasuredTooSmall = false;
  ChainHead[] mHorizontalChainsArray = new ChainHead[4];
  int mHorizontalChainsSize = 0;
  public boolean mHorizontalWrapOptimized = false;
  private boolean mIsRtl = false;
  private int mOptimizationLevel = 7;
  int mPaddingBottom;
  int mPaddingLeft;
  int mPaddingRight;
  int mPaddingTop;
  public boolean mSkipSolver = false;
  private Snapshot mSnapshot;
  protected LinearSystem mSystem = new LinearSystem();
  ChainHead[] mVerticalChainsArray = new ChainHead[4];
  int mVerticalChainsSize = 0;
  public boolean mVerticalWrapOptimized = false;
  public List<ConstraintWidgetGroup> mWidgetGroups = new ArrayList();
  private boolean mWidthMeasuredTooSmall = false;
  public int mWrapFixedHeight = 0;
  public int mWrapFixedWidth = 0;
  
  public ConstraintWidgetContainer() {}
  
  public ConstraintWidgetContainer(int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
  }
  
  public ConstraintWidgetContainer(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  private void addHorizontalChain(ConstraintWidget paramConstraintWidget)
  {
    if (this.mHorizontalChainsSize + 1 >= this.mHorizontalChainsArray.length) {
      this.mHorizontalChainsArray = ((ChainHead[])Arrays.copyOf(this.mHorizontalChainsArray, this.mHorizontalChainsArray.length * 2));
    }
    this.mHorizontalChainsArray[this.mHorizontalChainsSize] = new ChainHead(paramConstraintWidget, 0, isRtl());
    this.mHorizontalChainsSize += 1;
  }
  
  private void addVerticalChain(ConstraintWidget paramConstraintWidget)
  {
    if (this.mVerticalChainsSize + 1 >= this.mVerticalChainsArray.length) {
      this.mVerticalChainsArray = ((ChainHead[])Arrays.copyOf(this.mVerticalChainsArray, this.mVerticalChainsArray.length * 2));
    }
    this.mVerticalChainsArray[this.mVerticalChainsSize] = new ChainHead(paramConstraintWidget, 1, isRtl());
    this.mVerticalChainsSize += 1;
  }
  
  private void resetChains()
  {
    this.mHorizontalChainsSize = 0;
    this.mVerticalChainsSize = 0;
  }
  
  void addChain(ConstraintWidget paramConstraintWidget, int paramInt)
  {
    if (paramInt == 0) {
      addHorizontalChain(paramConstraintWidget);
    }
    while (paramInt != 1) {
      return;
    }
    addVerticalChain(paramConstraintWidget);
  }
  
  public boolean addChildrenToSolver(LinearSystem paramLinearSystem)
  {
    addToSolver(paramLinearSystem);
    int j = this.mChildren.size();
    int i = 0;
    if (i < j)
    {
      ConstraintWidget localConstraintWidget = (ConstraintWidget)this.mChildren.get(i);
      if ((localConstraintWidget instanceof ConstraintWidgetContainer))
      {
        ConstraintWidget.DimensionBehaviour localDimensionBehaviour1 = localConstraintWidget.mListDimensionBehaviors[0];
        ConstraintWidget.DimensionBehaviour localDimensionBehaviour2 = localConstraintWidget.mListDimensionBehaviors[1];
        if (localDimensionBehaviour1 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
          localConstraintWidget.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
        }
        if (localDimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
          localConstraintWidget.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
        }
        localConstraintWidget.addToSolver(paramLinearSystem);
        if (localDimensionBehaviour1 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
          localConstraintWidget.setHorizontalDimensionBehaviour(localDimensionBehaviour1);
        }
        if (localDimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
          localConstraintWidget.setVerticalDimensionBehaviour(localDimensionBehaviour2);
        }
      }
      for (;;)
      {
        i += 1;
        break;
        Optimizer.checkMatchParent(this, paramLinearSystem, localConstraintWidget);
        localConstraintWidget.addToSolver(paramLinearSystem);
      }
    }
    if (this.mHorizontalChainsSize > 0) {
      Chain.applyChainConstraints(this, paramLinearSystem, 0);
    }
    if (this.mVerticalChainsSize > 0) {
      Chain.applyChainConstraints(this, paramLinearSystem, 1);
    }
    return true;
  }
  
  public void analyze(int paramInt)
  {
    super.analyze(paramInt);
    int j = this.mChildren.size();
    int i = 0;
    while (i < j)
    {
      ((ConstraintWidget)this.mChildren.get(i)).analyze(paramInt);
      i += 1;
    }
  }
  
  public void fillMetrics(Metrics paramMetrics)
  {
    this.mSystem.fillMetrics(paramMetrics);
  }
  
  public ArrayList<Guideline> getHorizontalGuidelines()
  {
    ArrayList localArrayList = new ArrayList();
    int j = this.mChildren.size();
    int i = 0;
    while (i < j)
    {
      Object localObject = (ConstraintWidget)this.mChildren.get(i);
      if ((localObject instanceof Guideline))
      {
        localObject = (Guideline)localObject;
        if (((Guideline)localObject).getOrientation() == 0) {
          localArrayList.add(localObject);
        }
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public int getOptimizationLevel()
  {
    return this.mOptimizationLevel;
  }
  
  public LinearSystem getSystem()
  {
    return this.mSystem;
  }
  
  public String getType()
  {
    return "ConstraintLayout";
  }
  
  public ArrayList<Guideline> getVerticalGuidelines()
  {
    ArrayList localArrayList = new ArrayList();
    int j = this.mChildren.size();
    int i = 0;
    while (i < j)
    {
      Object localObject = (ConstraintWidget)this.mChildren.get(i);
      if ((localObject instanceof Guideline))
      {
        localObject = (Guideline)localObject;
        if (((Guideline)localObject).getOrientation() == 1) {
          localArrayList.add(localObject);
        }
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public List<ConstraintWidgetGroup> getWidgetGroups()
  {
    return this.mWidgetGroups;
  }
  
  public boolean handlesInternalConstraints()
  {
    return false;
  }
  
  public boolean isHeightMeasuredTooSmall()
  {
    return this.mHeightMeasuredTooSmall;
  }
  
  public boolean isRtl()
  {
    return this.mIsRtl;
  }
  
  public boolean isWidthMeasuredTooSmall()
  {
    return this.mWidthMeasuredTooSmall;
  }
  
  /* Error */
  public void layout()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 213	android/support/constraint/solver/widgets/ConstraintWidgetContainer:mX	I
    //   4: istore 8
    //   6: aload_0
    //   7: getfield 216	android/support/constraint/solver/widgets/ConstraintWidgetContainer:mY	I
    //   10: istore 9
    //   12: iconst_0
    //   13: aload_0
    //   14: invokevirtual 219	android/support/constraint/solver/widgets/ConstraintWidgetContainer:getWidth	()I
    //   17: invokestatic 225	java/lang/Math:max	(II)I
    //   20: istore 10
    //   22: iconst_0
    //   23: aload_0
    //   24: invokevirtual 228	android/support/constraint/solver/widgets/ConstraintWidgetContainer:getHeight	()I
    //   27: invokestatic 225	java/lang/Math:max	(II)I
    //   30: istore 11
    //   32: aload_0
    //   33: iconst_0
    //   34: putfield 83	android/support/constraint/solver/widgets/ConstraintWidgetContainer:mWidthMeasuredTooSmall	Z
    //   37: aload_0
    //   38: iconst_0
    //   39: putfield 85	android/support/constraint/solver/widgets/ConstraintWidgetContainer:mHeightMeasuredTooSmall	Z
    //   42: aload_0
    //   43: getfield 232	android/support/constraint/solver/widgets/ConstraintWidgetContainer:mParent	Landroid/support/constraint/solver/widgets/ConstraintWidget;
    //   46: ifnull +354 -> 400
    //   49: aload_0
    //   50: getfield 234	android/support/constraint/solver/widgets/ConstraintWidgetContainer:mSnapshot	Landroid/support/constraint/solver/widgets/Snapshot;
    //   53: ifnonnull +15 -> 68
    //   56: aload_0
    //   57: new 236	android/support/constraint/solver/widgets/Snapshot
    //   60: dup
    //   61: aload_0
    //   62: invokespecial 238	android/support/constraint/solver/widgets/Snapshot:<init>	(Landroid/support/constraint/solver/widgets/ConstraintWidget;)V
    //   65: putfield 234	android/support/constraint/solver/widgets/ConstraintWidgetContainer:mSnapshot	Landroid/support/constraint/solver/widgets/Snapshot;
    //   68: aload_0
    //   69: getfield 234	android/support/constraint/solver/widgets/ConstraintWidgetContainer:mSnapshot	Landroid/support/constraint/solver/widgets/Snapshot;
    //   72: aload_0
    //   73: invokevirtual 241	android/support/constraint/solver/widgets/Snapshot:updateFrom	(Landroid/support/constraint/solver/widgets/ConstraintWidget;)V
    //   76: aload_0
    //   77: aload_0
    //   78: getfield 243	android/support/constraint/solver/widgets/ConstraintWidgetContainer:mPaddingLeft	I
    //   81: invokevirtual 246	android/support/constraint/solver/widgets/ConstraintWidgetContainer:setX	(I)V
    //   84: aload_0
    //   85: aload_0
    //   86: getfield 248	android/support/constraint/solver/widgets/ConstraintWidgetContainer:mPaddingTop	I
    //   89: invokevirtual 251	android/support/constraint/solver/widgets/ConstraintWidgetContainer:setY	(I)V
    //   92: aload_0
    //   93: invokevirtual 254	android/support/constraint/solver/widgets/ConstraintWidgetContainer:resetAnchors	()V
    //   96: aload_0
    //   97: aload_0
    //   98: getfield 52	android/support/constraint/solver/widgets/ConstraintWidgetContainer:mSystem	Landroid/support/constraint/solver/LinearSystem;
    //   101: invokevirtual 258	android/support/constraint/solver/LinearSystem:getCache	()Landroid/support/constraint/solver/Cache;
    //   104: invokevirtual 262	android/support/constraint/solver/widgets/ConstraintWidgetContainer:resetSolverVariables	(Landroid/support/constraint/solver/Cache;)V
    //   107: aload_0
    //   108: getfield 79	android/support/constraint/solver/widgets/ConstraintWidgetContainer:mOptimizationLevel	I
    //   111: ifeq +302 -> 413
    //   114: aload_0
    //   115: bipush 8
    //   117: invokevirtual 266	android/support/constraint/solver/widgets/ConstraintWidgetContainer:optimizeFor	(I)Z
    //   120: ifne +7 -> 127
    //   123: aload_0
    //   124: invokevirtual 269	android/support/constraint/solver/widgets/ConstraintWidgetContainer:optimizeReset	()V
    //   127: aload_0
    //   128: bipush 32
    //   130: invokevirtual 266	android/support/constraint/solver/widgets/ConstraintWidgetContainer:optimizeFor	(I)Z
    //   133: ifne +7 -> 140
    //   136: aload_0
    //   137: invokevirtual 272	android/support/constraint/solver/widgets/ConstraintWidgetContainer:optimize	()V
    //   140: aload_0
    //   141: getfield 52	android/support/constraint/solver/widgets/ConstraintWidgetContainer:mSystem	Landroid/support/constraint/solver/LinearSystem;
    //   144: iconst_1
    //   145: putfield 275	android/support/constraint/solver/LinearSystem:graphOptimizer	Z
    //   148: iconst_0
    //   149: istore_1
    //   150: aload_0
    //   151: getfield 276	android/support/constraint/solver/widgets/ConstraintWidgetContainer:mListDimensionBehaviors	[Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   154: iconst_1
    //   155: aaload
    //   156: astore 18
    //   158: aload_0
    //   159: getfield 276	android/support/constraint/solver/widgets/ConstraintWidgetContainer:mListDimensionBehaviors	[Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   162: iconst_0
    //   163: aaload
    //   164: astore 19
    //   166: aload_0
    //   167: invokespecial 278	android/support/constraint/solver/widgets/ConstraintWidgetContainer:resetChains	()V
    //   170: aload_0
    //   171: getfield 67	android/support/constraint/solver/widgets/ConstraintWidgetContainer:mWidgetGroups	Ljava/util/List;
    //   174: invokeinterface 281 1 0
    //   179: ifne +33 -> 212
    //   182: aload_0
    //   183: getfield 67	android/support/constraint/solver/widgets/ConstraintWidgetContainer:mWidgetGroups	Ljava/util/List;
    //   186: invokeinterface 284 1 0
    //   191: aload_0
    //   192: getfield 67	android/support/constraint/solver/widgets/ConstraintWidgetContainer:mWidgetGroups	Ljava/util/List;
    //   195: iconst_0
    //   196: new 286	android/support/constraint/solver/widgets/ConstraintWidgetGroup
    //   199: dup
    //   200: aload_0
    //   201: getfield 128	android/support/constraint/solver/widgets/ConstraintWidgetContainer:mChildren	Ljava/util/ArrayList;
    //   204: invokespecial 289	android/support/constraint/solver/widgets/ConstraintWidgetGroup:<init>	(Ljava/util/List;)V
    //   207: invokeinterface 292 3 0
    //   212: aload_0
    //   213: getfield 67	android/support/constraint/solver/widgets/ConstraintWidgetContainer:mWidgetGroups	Ljava/util/List;
    //   216: invokeinterface 281 1 0
    //   221: istore 12
    //   223: aload_0
    //   224: getfield 128	android/support/constraint/solver/widgets/ConstraintWidgetContainer:mChildren	Ljava/util/ArrayList;
    //   227: astore 20
    //   229: aload_0
    //   230: invokevirtual 296	android/support/constraint/solver/widgets/ConstraintWidgetContainer:getHorizontalDimensionBehaviour	()Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   233: getstatic 148	android/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour:WRAP_CONTENT	Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   236: if_acmpeq +13 -> 249
    //   239: aload_0
    //   240: invokevirtual 299	android/support/constraint/solver/widgets/ConstraintWidgetContainer:getVerticalDimensionBehaviour	()Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   243: getstatic 148	android/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour:WRAP_CONTENT	Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   246: if_acmpne +178 -> 424
    //   249: iconst_1
    //   250: istore_3
    //   251: iconst_0
    //   252: istore 4
    //   254: iload 4
    //   256: iload 12
    //   258: if_icmpge +898 -> 1156
    //   261: aload_0
    //   262: getfield 81	android/support/constraint/solver/widgets/ConstraintWidgetContainer:mSkipSolver	Z
    //   265: ifne +891 -> 1156
    //   268: iload_1
    //   269: istore_2
    //   270: aload_0
    //   271: getfield 67	android/support/constraint/solver/widgets/ConstraintWidgetContainer:mWidgetGroups	Ljava/util/List;
    //   274: iload 4
    //   276: invokeinterface 300 2 0
    //   281: checkcast 286	android/support/constraint/solver/widgets/ConstraintWidgetGroup
    //   284: getfield 301	android/support/constraint/solver/widgets/ConstraintWidgetGroup:mSkipSolver	Z
    //   287: ifne +858 -> 1145
    //   290: aload_0
    //   291: bipush 32
    //   293: invokevirtual 266	android/support/constraint/solver/widgets/ConstraintWidgetContainer:optimizeFor	(I)Z
    //   296: ifeq +47 -> 343
    //   299: aload_0
    //   300: invokevirtual 296	android/support/constraint/solver/widgets/ConstraintWidgetContainer:getHorizontalDimensionBehaviour	()Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   303: getstatic 151	android/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour:FIXED	Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   306: if_acmpne +123 -> 429
    //   309: aload_0
    //   310: invokevirtual 299	android/support/constraint/solver/widgets/ConstraintWidgetContainer:getVerticalDimensionBehaviour	()Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   313: getstatic 151	android/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour:FIXED	Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   316: if_acmpne +113 -> 429
    //   319: aload_0
    //   320: aload_0
    //   321: getfield 67	android/support/constraint/solver/widgets/ConstraintWidgetContainer:mWidgetGroups	Ljava/util/List;
    //   324: iload 4
    //   326: invokeinterface 300 2 0
    //   331: checkcast 286	android/support/constraint/solver/widgets/ConstraintWidgetGroup
    //   334: invokevirtual 304	android/support/constraint/solver/widgets/ConstraintWidgetGroup:getWidgetsToSolve	()Ljava/util/List;
    //   337: checkcast 64	java/util/ArrayList
    //   340: putfield 128	android/support/constraint/solver/widgets/ConstraintWidgetContainer:mChildren	Ljava/util/ArrayList;
    //   343: aload_0
    //   344: invokespecial 278	android/support/constraint/solver/widgets/ConstraintWidgetContainer:resetChains	()V
    //   347: aload_0
    //   348: getfield 128	android/support/constraint/solver/widgets/ConstraintWidgetContainer:mChildren	Ljava/util/ArrayList;
    //   351: invokevirtual 132	java/util/ArrayList:size	()I
    //   354: istore 13
    //   356: iconst_0
    //   357: istore_2
    //   358: iload_2
    //   359: iload 13
    //   361: if_icmpge +95 -> 456
    //   364: aload_0
    //   365: getfield 128	android/support/constraint/solver/widgets/ConstraintWidgetContainer:mChildren	Ljava/util/ArrayList;
    //   368: iload_2
    //   369: invokevirtual 136	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   372: checkcast 138	android/support/constraint/solver/widgets/ConstraintWidget
    //   375: astore 17
    //   377: aload 17
    //   379: instanceof 4
    //   382: ifeq +11 -> 393
    //   385: aload 17
    //   387: checkcast 4	android/support/constraint/solver/widgets/WidgetContainer
    //   390: invokevirtual 306	android/support/constraint/solver/widgets/WidgetContainer:layout	()V
    //   393: iload_2
    //   394: iconst_1
    //   395: iadd
    //   396: istore_2
    //   397: goto -39 -> 358
    //   400: aload_0
    //   401: iconst_0
    //   402: putfield 213	android/support/constraint/solver/widgets/ConstraintWidgetContainer:mX	I
    //   405: aload_0
    //   406: iconst_0
    //   407: putfield 216	android/support/constraint/solver/widgets/ConstraintWidgetContainer:mY	I
    //   410: goto -303 -> 107
    //   413: aload_0
    //   414: getfield 52	android/support/constraint/solver/widgets/ConstraintWidgetContainer:mSystem	Landroid/support/constraint/solver/LinearSystem;
    //   417: iconst_0
    //   418: putfield 275	android/support/constraint/solver/LinearSystem:graphOptimizer	Z
    //   421: goto -273 -> 148
    //   424: iconst_0
    //   425: istore_3
    //   426: goto -175 -> 251
    //   429: aload_0
    //   430: aload_0
    //   431: getfield 67	android/support/constraint/solver/widgets/ConstraintWidgetContainer:mWidgetGroups	Ljava/util/List;
    //   434: iload 4
    //   436: invokeinterface 300 2 0
    //   441: checkcast 286	android/support/constraint/solver/widgets/ConstraintWidgetGroup
    //   444: getfield 309	android/support/constraint/solver/widgets/ConstraintWidgetGroup:mConstrainedGroup	Ljava/util/List;
    //   447: checkcast 64	java/util/ArrayList
    //   450: putfield 128	android/support/constraint/solver/widgets/ConstraintWidgetContainer:mChildren	Ljava/util/ArrayList;
    //   453: goto -110 -> 343
    //   456: iconst_1
    //   457: istore 15
    //   459: iconst_0
    //   460: istore_2
    //   461: iload 15
    //   463: ifeq +663 -> 1126
    //   466: iload_2
    //   467: iconst_1
    //   468: iadd
    //   469: istore 7
    //   471: aload_0
    //   472: getfield 52	android/support/constraint/solver/widgets/ConstraintWidgetContainer:mSystem	Landroid/support/constraint/solver/LinearSystem;
    //   475: invokevirtual 312	android/support/constraint/solver/LinearSystem:reset	()V
    //   478: aload_0
    //   479: invokespecial 278	android/support/constraint/solver/widgets/ConstraintWidgetContainer:resetChains	()V
    //   482: aload_0
    //   483: aload_0
    //   484: getfield 52	android/support/constraint/solver/widgets/ConstraintWidgetContainer:mSystem	Landroid/support/constraint/solver/LinearSystem;
    //   487: invokevirtual 315	android/support/constraint/solver/widgets/ConstraintWidgetContainer:createObjectVariables	(Landroid/support/constraint/solver/LinearSystem;)V
    //   490: iconst_0
    //   491: istore_2
    //   492: iload_2
    //   493: iload 13
    //   495: if_icmpge +28 -> 523
    //   498: aload_0
    //   499: getfield 128	android/support/constraint/solver/widgets/ConstraintWidgetContainer:mChildren	Ljava/util/ArrayList;
    //   502: iload_2
    //   503: invokevirtual 136	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   506: checkcast 138	android/support/constraint/solver/widgets/ConstraintWidget
    //   509: aload_0
    //   510: getfield 52	android/support/constraint/solver/widgets/ConstraintWidgetContainer:mSystem	Landroid/support/constraint/solver/LinearSystem;
    //   513: invokevirtual 316	android/support/constraint/solver/widgets/ConstraintWidget:createObjectVariables	(Landroid/support/constraint/solver/LinearSystem;)V
    //   516: iload_2
    //   517: iconst_1
    //   518: iadd
    //   519: istore_2
    //   520: goto -28 -> 492
    //   523: aload_0
    //   524: aload_0
    //   525: getfield 52	android/support/constraint/solver/widgets/ConstraintWidgetContainer:mSystem	Landroid/support/constraint/solver/LinearSystem;
    //   528: invokevirtual 318	android/support/constraint/solver/widgets/ConstraintWidgetContainer:addChildrenToSolver	(Landroid/support/constraint/solver/LinearSystem;)Z
    //   531: istore 16
    //   533: iload 16
    //   535: istore 15
    //   537: iload 15
    //   539: istore 16
    //   541: iload 15
    //   543: ifeq +14 -> 557
    //   546: aload_0
    //   547: getfield 52	android/support/constraint/solver/widgets/ConstraintWidgetContainer:mSystem	Landroid/support/constraint/solver/LinearSystem;
    //   550: invokevirtual 321	android/support/constraint/solver/LinearSystem:minimize	()V
    //   553: iload 15
    //   555: istore 16
    //   557: iload 16
    //   559: ifeq +156 -> 715
    //   562: aload_0
    //   563: aload_0
    //   564: getfield 52	android/support/constraint/solver/widgets/ConstraintWidgetContainer:mSystem	Landroid/support/constraint/solver/LinearSystem;
    //   567: getstatic 325	android/support/constraint/solver/widgets/Optimizer:flags	[Z
    //   570: invokevirtual 329	android/support/constraint/solver/widgets/ConstraintWidgetContainer:updateChildrenFromSolver	(Landroid/support/constraint/solver/LinearSystem;[Z)V
    //   573: iconst_0
    //   574: istore 16
    //   576: iload 16
    //   578: istore 15
    //   580: iload_1
    //   581: istore_2
    //   582: iload_3
    //   583: ifeq +330 -> 913
    //   586: iload 16
    //   588: istore 15
    //   590: iload_1
    //   591: istore_2
    //   592: iload 7
    //   594: bipush 8
    //   596: if_icmpge +317 -> 913
    //   599: iload 16
    //   601: istore 15
    //   603: iload_1
    //   604: istore_2
    //   605: getstatic 325	android/support/constraint/solver/widgets/Optimizer:flags	[Z
    //   608: iconst_2
    //   609: baload
    //   610: ifeq +303 -> 913
    //   613: iconst_0
    //   614: istore 6
    //   616: iconst_0
    //   617: istore_2
    //   618: iconst_0
    //   619: istore 5
    //   621: iload 5
    //   623: iload 13
    //   625: if_icmpge +196 -> 821
    //   628: aload_0
    //   629: getfield 128	android/support/constraint/solver/widgets/ConstraintWidgetContainer:mChildren	Ljava/util/ArrayList;
    //   632: iload 5
    //   634: invokevirtual 136	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   637: checkcast 138	android/support/constraint/solver/widgets/ConstraintWidget
    //   640: astore 17
    //   642: iload 6
    //   644: aload 17
    //   646: getfield 330	android/support/constraint/solver/widgets/ConstraintWidget:mX	I
    //   649: aload 17
    //   651: invokevirtual 331	android/support/constraint/solver/widgets/ConstraintWidget:getWidth	()I
    //   654: iadd
    //   655: invokestatic 225	java/lang/Math:max	(II)I
    //   658: istore 6
    //   660: aload 17
    //   662: getfield 332	android/support/constraint/solver/widgets/ConstraintWidget:mY	I
    //   665: istore 14
    //   667: iload_2
    //   668: aload 17
    //   670: invokevirtual 333	android/support/constraint/solver/widgets/ConstraintWidget:getHeight	()I
    //   673: iload 14
    //   675: iadd
    //   676: invokestatic 225	java/lang/Math:max	(II)I
    //   679: istore_2
    //   680: iload 5
    //   682: iconst_1
    //   683: iadd
    //   684: istore 5
    //   686: goto -65 -> 621
    //   689: astore 17
    //   691: getstatic 339	java/lang/System:out	Ljava/io/PrintStream;
    //   694: ldc_w 341
    //   697: aload 17
    //   699: invokestatic 347	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   702: invokevirtual 351	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   705: invokevirtual 357	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   708: iload 15
    //   710: istore 16
    //   712: goto -155 -> 557
    //   715: aload_0
    //   716: aload_0
    //   717: getfield 52	android/support/constraint/solver/widgets/ConstraintWidgetContainer:mSystem	Landroid/support/constraint/solver/LinearSystem;
    //   720: invokevirtual 360	android/support/constraint/solver/widgets/ConstraintWidgetContainer:updateFromSolver	(Landroid/support/constraint/solver/LinearSystem;)V
    //   723: iconst_0
    //   724: istore_2
    //   725: iload_2
    //   726: iload 13
    //   728: if_icmpge -155 -> 573
    //   731: aload_0
    //   732: getfield 128	android/support/constraint/solver/widgets/ConstraintWidgetContainer:mChildren	Ljava/util/ArrayList;
    //   735: iload_2
    //   736: invokevirtual 136	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   739: checkcast 138	android/support/constraint/solver/widgets/ConstraintWidget
    //   742: astore 17
    //   744: aload 17
    //   746: getfield 142	android/support/constraint/solver/widgets/ConstraintWidget:mListDimensionBehaviors	[Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   749: iconst_0
    //   750: aaload
    //   751: getstatic 363	android/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour:MATCH_CONSTRAINT	Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   754: if_acmpne +25 -> 779
    //   757: aload 17
    //   759: invokevirtual 331	android/support/constraint/solver/widgets/ConstraintWidget:getWidth	()I
    //   762: aload 17
    //   764: invokevirtual 366	android/support/constraint/solver/widgets/ConstraintWidget:getWrapWidth	()I
    //   767: if_icmpge +12 -> 779
    //   770: getstatic 325	android/support/constraint/solver/widgets/Optimizer:flags	[Z
    //   773: iconst_2
    //   774: iconst_1
    //   775: bastore
    //   776: goto -203 -> 573
    //   779: aload 17
    //   781: getfield 142	android/support/constraint/solver/widgets/ConstraintWidget:mListDimensionBehaviors	[Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   784: iconst_1
    //   785: aaload
    //   786: getstatic 363	android/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour:MATCH_CONSTRAINT	Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   789: if_acmpne +25 -> 814
    //   792: aload 17
    //   794: invokevirtual 333	android/support/constraint/solver/widgets/ConstraintWidget:getHeight	()I
    //   797: aload 17
    //   799: invokevirtual 369	android/support/constraint/solver/widgets/ConstraintWidget:getWrapHeight	()I
    //   802: if_icmpge +12 -> 814
    //   805: getstatic 325	android/support/constraint/solver/widgets/Optimizer:flags	[Z
    //   808: iconst_2
    //   809: iconst_1
    //   810: bastore
    //   811: goto -238 -> 573
    //   814: iload_2
    //   815: iconst_1
    //   816: iadd
    //   817: istore_2
    //   818: goto -93 -> 725
    //   821: aload_0
    //   822: getfield 372	android/support/constraint/solver/widgets/ConstraintWidgetContainer:mMinWidth	I
    //   825: iload 6
    //   827: invokestatic 225	java/lang/Math:max	(II)I
    //   830: istore 5
    //   832: aload_0
    //   833: getfield 375	android/support/constraint/solver/widgets/ConstraintWidgetContainer:mMinHeight	I
    //   836: iload_2
    //   837: invokestatic 225	java/lang/Math:max	(II)I
    //   840: istore_2
    //   841: aload 19
    //   843: getstatic 148	android/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour:WRAP_CONTENT	Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   846: if_acmpne +472 -> 1318
    //   849: aload_0
    //   850: invokevirtual 219	android/support/constraint/solver/widgets/ConstraintWidgetContainer:getWidth	()I
    //   853: iload 5
    //   855: if_icmpge +463 -> 1318
    //   858: aload_0
    //   859: iload 5
    //   861: invokevirtual 378	android/support/constraint/solver/widgets/ConstraintWidgetContainer:setWidth	(I)V
    //   864: aload_0
    //   865: getfield 276	android/support/constraint/solver/widgets/ConstraintWidgetContainer:mListDimensionBehaviors	[Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   868: iconst_0
    //   869: getstatic 148	android/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour:WRAP_CONTENT	Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   872: aastore
    //   873: iconst_1
    //   874: istore 15
    //   876: iconst_1
    //   877: istore_1
    //   878: aload 18
    //   880: getstatic 148	android/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour:WRAP_CONTENT	Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   883: if_acmpne +430 -> 1313
    //   886: aload_0
    //   887: invokevirtual 228	android/support/constraint/solver/widgets/ConstraintWidgetContainer:getHeight	()I
    //   890: iload_2
    //   891: if_icmpge +422 -> 1313
    //   894: aload_0
    //   895: iload_2
    //   896: invokevirtual 381	android/support/constraint/solver/widgets/ConstraintWidgetContainer:setHeight	(I)V
    //   899: aload_0
    //   900: getfield 276	android/support/constraint/solver/widgets/ConstraintWidgetContainer:mListDimensionBehaviors	[Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   903: iconst_1
    //   904: getstatic 148	android/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour:WRAP_CONTENT	Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   907: aastore
    //   908: iconst_1
    //   909: istore_2
    //   910: iconst_1
    //   911: istore 15
    //   913: aload_0
    //   914: getfield 372	android/support/constraint/solver/widgets/ConstraintWidgetContainer:mMinWidth	I
    //   917: aload_0
    //   918: invokevirtual 219	android/support/constraint/solver/widgets/ConstraintWidgetContainer:getWidth	()I
    //   921: invokestatic 225	java/lang/Math:max	(II)I
    //   924: istore 5
    //   926: iload_2
    //   927: istore_1
    //   928: iload 5
    //   930: aload_0
    //   931: invokevirtual 219	android/support/constraint/solver/widgets/ConstraintWidgetContainer:getWidth	()I
    //   934: if_icmple +23 -> 957
    //   937: aload_0
    //   938: iload 5
    //   940: invokevirtual 378	android/support/constraint/solver/widgets/ConstraintWidgetContainer:setWidth	(I)V
    //   943: aload_0
    //   944: getfield 276	android/support/constraint/solver/widgets/ConstraintWidgetContainer:mListDimensionBehaviors	[Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   947: iconst_0
    //   948: getstatic 151	android/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour:FIXED	Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   951: aastore
    //   952: iconst_1
    //   953: istore_1
    //   954: iconst_1
    //   955: istore 15
    //   957: aload_0
    //   958: getfield 375	android/support/constraint/solver/widgets/ConstraintWidgetContainer:mMinHeight	I
    //   961: aload_0
    //   962: invokevirtual 228	android/support/constraint/solver/widgets/ConstraintWidgetContainer:getHeight	()I
    //   965: invokestatic 225	java/lang/Math:max	(II)I
    //   968: istore_2
    //   969: iload_2
    //   970: aload_0
    //   971: invokevirtual 228	android/support/constraint/solver/widgets/ConstraintWidgetContainer:getHeight	()I
    //   974: if_icmple +336 -> 1310
    //   977: aload_0
    //   978: iload_2
    //   979: invokevirtual 381	android/support/constraint/solver/widgets/ConstraintWidgetContainer:setHeight	(I)V
    //   982: aload_0
    //   983: getfield 276	android/support/constraint/solver/widgets/ConstraintWidgetContainer:mListDimensionBehaviors	[Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   986: iconst_1
    //   987: getstatic 151	android/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour:FIXED	Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   990: aastore
    //   991: iconst_1
    //   992: istore_1
    //   993: iconst_1
    //   994: istore 15
    //   996: iload_1
    //   997: ifne +310 -> 1307
    //   1000: aload_0
    //   1001: getfield 276	android/support/constraint/solver/widgets/ConstraintWidgetContainer:mListDimensionBehaviors	[Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   1004: iconst_0
    //   1005: aaload
    //   1006: getstatic 148	android/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour:WRAP_CONTENT	Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   1009: if_acmpne +289 -> 1298
    //   1012: iload 10
    //   1014: ifle +284 -> 1298
    //   1017: aload_0
    //   1018: invokevirtual 219	android/support/constraint/solver/widgets/ConstraintWidgetContainer:getWidth	()I
    //   1021: iload 10
    //   1023: if_icmple +275 -> 1298
    //   1026: aload_0
    //   1027: iconst_1
    //   1028: putfield 83	android/support/constraint/solver/widgets/ConstraintWidgetContainer:mWidthMeasuredTooSmall	Z
    //   1031: iconst_1
    //   1032: istore_2
    //   1033: aload_0
    //   1034: getfield 276	android/support/constraint/solver/widgets/ConstraintWidgetContainer:mListDimensionBehaviors	[Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   1037: iconst_0
    //   1038: getstatic 151	android/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour:FIXED	Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   1041: aastore
    //   1042: aload_0
    //   1043: iload 10
    //   1045: invokevirtual 378	android/support/constraint/solver/widgets/ConstraintWidgetContainer:setWidth	(I)V
    //   1048: iconst_1
    //   1049: istore 16
    //   1051: iload 16
    //   1053: istore 15
    //   1055: iload_2
    //   1056: istore_1
    //   1057: aload_0
    //   1058: getfield 276	android/support/constraint/solver/widgets/ConstraintWidgetContainer:mListDimensionBehaviors	[Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   1061: iconst_1
    //   1062: aaload
    //   1063: getstatic 148	android/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour:WRAP_CONTENT	Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   1066: if_acmpne +54 -> 1120
    //   1069: iload 16
    //   1071: istore 15
    //   1073: iload_2
    //   1074: istore_1
    //   1075: iload 11
    //   1077: ifle +43 -> 1120
    //   1080: iload 16
    //   1082: istore 15
    //   1084: iload_2
    //   1085: istore_1
    //   1086: aload_0
    //   1087: invokevirtual 228	android/support/constraint/solver/widgets/ConstraintWidgetContainer:getHeight	()I
    //   1090: iload 11
    //   1092: if_icmple +28 -> 1120
    //   1095: aload_0
    //   1096: iconst_1
    //   1097: putfield 85	android/support/constraint/solver/widgets/ConstraintWidgetContainer:mHeightMeasuredTooSmall	Z
    //   1100: iconst_1
    //   1101: istore_1
    //   1102: aload_0
    //   1103: getfield 276	android/support/constraint/solver/widgets/ConstraintWidgetContainer:mListDimensionBehaviors	[Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   1106: iconst_1
    //   1107: getstatic 151	android/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour:FIXED	Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   1110: aastore
    //   1111: aload_0
    //   1112: iload 11
    //   1114: invokevirtual 381	android/support/constraint/solver/widgets/ConstraintWidgetContainer:setHeight	(I)V
    //   1117: iconst_1
    //   1118: istore 15
    //   1120: iload 7
    //   1122: istore_2
    //   1123: goto -662 -> 461
    //   1126: aload_0
    //   1127: getfield 67	android/support/constraint/solver/widgets/ConstraintWidgetContainer:mWidgetGroups	Ljava/util/List;
    //   1130: iload 4
    //   1132: invokeinterface 300 2 0
    //   1137: checkcast 286	android/support/constraint/solver/widgets/ConstraintWidgetGroup
    //   1140: invokevirtual 384	android/support/constraint/solver/widgets/ConstraintWidgetGroup:updateUnresolvedWidgets	()V
    //   1143: iload_1
    //   1144: istore_2
    //   1145: iload 4
    //   1147: iconst_1
    //   1148: iadd
    //   1149: istore 4
    //   1151: iload_2
    //   1152: istore_1
    //   1153: goto -899 -> 254
    //   1156: aload_0
    //   1157: aload 20
    //   1159: checkcast 64	java/util/ArrayList
    //   1162: putfield 128	android/support/constraint/solver/widgets/ConstraintWidgetContainer:mChildren	Ljava/util/ArrayList;
    //   1165: aload_0
    //   1166: getfield 232	android/support/constraint/solver/widgets/ConstraintWidgetContainer:mParent	Landroid/support/constraint/solver/widgets/ConstraintWidget;
    //   1169: ifnull +109 -> 1278
    //   1172: aload_0
    //   1173: getfield 372	android/support/constraint/solver/widgets/ConstraintWidgetContainer:mMinWidth	I
    //   1176: aload_0
    //   1177: invokevirtual 219	android/support/constraint/solver/widgets/ConstraintWidgetContainer:getWidth	()I
    //   1180: invokestatic 225	java/lang/Math:max	(II)I
    //   1183: istore_2
    //   1184: aload_0
    //   1185: getfield 375	android/support/constraint/solver/widgets/ConstraintWidgetContainer:mMinHeight	I
    //   1188: aload_0
    //   1189: invokevirtual 228	android/support/constraint/solver/widgets/ConstraintWidgetContainer:getHeight	()I
    //   1192: invokestatic 225	java/lang/Math:max	(II)I
    //   1195: istore_3
    //   1196: aload_0
    //   1197: getfield 234	android/support/constraint/solver/widgets/ConstraintWidgetContainer:mSnapshot	Landroid/support/constraint/solver/widgets/Snapshot;
    //   1200: aload_0
    //   1201: invokevirtual 387	android/support/constraint/solver/widgets/Snapshot:applyTo	(Landroid/support/constraint/solver/widgets/ConstraintWidget;)V
    //   1204: aload_0
    //   1205: iload_2
    //   1206: aload_0
    //   1207: getfield 243	android/support/constraint/solver/widgets/ConstraintWidgetContainer:mPaddingLeft	I
    //   1210: iadd
    //   1211: aload_0
    //   1212: getfield 389	android/support/constraint/solver/widgets/ConstraintWidgetContainer:mPaddingRight	I
    //   1215: iadd
    //   1216: invokevirtual 378	android/support/constraint/solver/widgets/ConstraintWidgetContainer:setWidth	(I)V
    //   1219: aload_0
    //   1220: aload_0
    //   1221: getfield 248	android/support/constraint/solver/widgets/ConstraintWidgetContainer:mPaddingTop	I
    //   1224: iload_3
    //   1225: iadd
    //   1226: aload_0
    //   1227: getfield 391	android/support/constraint/solver/widgets/ConstraintWidgetContainer:mPaddingBottom	I
    //   1230: iadd
    //   1231: invokevirtual 381	android/support/constraint/solver/widgets/ConstraintWidgetContainer:setHeight	(I)V
    //   1234: iload_1
    //   1235: ifeq +19 -> 1254
    //   1238: aload_0
    //   1239: getfield 276	android/support/constraint/solver/widgets/ConstraintWidgetContainer:mListDimensionBehaviors	[Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   1242: iconst_0
    //   1243: aload 19
    //   1245: aastore
    //   1246: aload_0
    //   1247: getfield 276	android/support/constraint/solver/widgets/ConstraintWidgetContainer:mListDimensionBehaviors	[Landroid/support/constraint/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   1250: iconst_1
    //   1251: aload 18
    //   1253: aastore
    //   1254: aload_0
    //   1255: aload_0
    //   1256: getfield 52	android/support/constraint/solver/widgets/ConstraintWidgetContainer:mSystem	Landroid/support/constraint/solver/LinearSystem;
    //   1259: invokevirtual 258	android/support/constraint/solver/LinearSystem:getCache	()Landroid/support/constraint/solver/Cache;
    //   1262: invokevirtual 262	android/support/constraint/solver/widgets/ConstraintWidgetContainer:resetSolverVariables	(Landroid/support/constraint/solver/Cache;)V
    //   1265: aload_0
    //   1266: aload_0
    //   1267: invokevirtual 395	android/support/constraint/solver/widgets/ConstraintWidgetContainer:getRootConstraintContainer	()Landroid/support/constraint/solver/widgets/ConstraintWidgetContainer;
    //   1270: if_acmpne +7 -> 1277
    //   1273: aload_0
    //   1274: invokevirtual 398	android/support/constraint/solver/widgets/ConstraintWidgetContainer:updateDrawPosition	()V
    //   1277: return
    //   1278: aload_0
    //   1279: iload 8
    //   1281: putfield 213	android/support/constraint/solver/widgets/ConstraintWidgetContainer:mX	I
    //   1284: aload_0
    //   1285: iload 9
    //   1287: putfield 216	android/support/constraint/solver/widgets/ConstraintWidgetContainer:mY	I
    //   1290: goto -56 -> 1234
    //   1293: astore 17
    //   1295: goto -604 -> 691
    //   1298: iload 15
    //   1300: istore 16
    //   1302: iload_1
    //   1303: istore_2
    //   1304: goto -253 -> 1051
    //   1307: goto -187 -> 1120
    //   1310: goto -314 -> 996
    //   1313: iload_1
    //   1314: istore_2
    //   1315: goto -402 -> 913
    //   1318: iconst_0
    //   1319: istore 15
    //   1321: goto -443 -> 878
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1324	0	this	ConstraintWidgetContainer
    //   149	1165	1	i	int
    //   269	1046	2	j	int
    //   250	976	3	k	int
    //   252	898	4	m	int
    //   619	320	5	n	int
    //   614	212	6	i1	int
    //   469	652	7	i2	int
    //   4	1276	8	i3	int
    //   10	1276	9	i4	int
    //   20	1024	10	i5	int
    //   30	1083	11	i6	int
    //   221	38	12	i7	int
    //   354	375	13	i8	int
    //   665	11	14	i9	int
    //   457	863	15	bool1	boolean
    //   531	770	16	bool2	boolean
    //   375	294	17	localConstraintWidget1	ConstraintWidget
    //   689	9	17	localException1	java.lang.Exception
    //   742	56	17	localConstraintWidget2	ConstraintWidget
    //   1293	1	17	localException2	java.lang.Exception
    //   156	1096	18	localDimensionBehaviour1	ConstraintWidget.DimensionBehaviour
    //   164	1080	19	localDimensionBehaviour2	ConstraintWidget.DimensionBehaviour
    //   227	931	20	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   471	490	689	java/lang/Exception
    //   498	516	689	java/lang/Exception
    //   523	533	689	java/lang/Exception
    //   546	553	1293	java/lang/Exception
  }
  
  public void optimize()
  {
    if (!optimizeFor(8)) {
      analyze(this.mOptimizationLevel);
    }
    solveGraph();
  }
  
  public boolean optimizeFor(int paramInt)
  {
    return (this.mOptimizationLevel & paramInt) == paramInt;
  }
  
  public void optimizeForDimensions(int paramInt1, int paramInt2)
  {
    if ((this.mListDimensionBehaviors[0] != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) && (this.mResolutionWidth != null)) {
      this.mResolutionWidth.resolve(paramInt1);
    }
    if ((this.mListDimensionBehaviors[1] != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) && (this.mResolutionHeight != null)) {
      this.mResolutionHeight.resolve(paramInt2);
    }
  }
  
  public void optimizeReset()
  {
    int j = this.mChildren.size();
    resetResolutionNodes();
    int i = 0;
    while (i < j)
    {
      ((ConstraintWidget)this.mChildren.get(i)).resetResolutionNodes();
      i += 1;
    }
  }
  
  public void preOptimize()
  {
    optimizeReset();
    analyze(this.mOptimizationLevel);
  }
  
  public void reset()
  {
    this.mSystem.reset();
    this.mPaddingLeft = 0;
    this.mPaddingRight = 0;
    this.mPaddingTop = 0;
    this.mPaddingBottom = 0;
    this.mWidgetGroups.clear();
    this.mSkipSolver = false;
    super.reset();
  }
  
  public void resetGraph()
  {
    ResolutionAnchor localResolutionAnchor1 = getAnchor(ConstraintAnchor.Type.LEFT).getResolutionNode();
    ResolutionAnchor localResolutionAnchor2 = getAnchor(ConstraintAnchor.Type.TOP).getResolutionNode();
    localResolutionAnchor1.invalidateAnchors();
    localResolutionAnchor2.invalidateAnchors();
    localResolutionAnchor1.resolve(null, 0.0F);
    localResolutionAnchor2.resolve(null, 0.0F);
  }
  
  public void setOptimizationLevel(int paramInt)
  {
    this.mOptimizationLevel = paramInt;
  }
  
  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mPaddingLeft = paramInt1;
    this.mPaddingTop = paramInt2;
    this.mPaddingRight = paramInt3;
    this.mPaddingBottom = paramInt4;
  }
  
  public void setRtl(boolean paramBoolean)
  {
    this.mIsRtl = paramBoolean;
  }
  
  public void solveGraph()
  {
    ResolutionAnchor localResolutionAnchor1 = getAnchor(ConstraintAnchor.Type.LEFT).getResolutionNode();
    ResolutionAnchor localResolutionAnchor2 = getAnchor(ConstraintAnchor.Type.TOP).getResolutionNode();
    localResolutionAnchor1.resolve(null, 0.0F);
    localResolutionAnchor2.resolve(null, 0.0F);
  }
  
  public void updateChildrenFromSolver(LinearSystem paramLinearSystem, boolean[] paramArrayOfBoolean)
  {
    paramArrayOfBoolean[2] = false;
    updateFromSolver(paramLinearSystem);
    int j = this.mChildren.size();
    int i = 0;
    while (i < j)
    {
      ConstraintWidget localConstraintWidget = (ConstraintWidget)this.mChildren.get(i);
      localConstraintWidget.updateFromSolver(paramLinearSystem);
      if ((localConstraintWidget.mListDimensionBehaviors[0] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) && (localConstraintWidget.getWidth() < localConstraintWidget.getWrapWidth())) {
        paramArrayOfBoolean[2] = true;
      }
      if ((localConstraintWidget.mListDimensionBehaviors[1] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) && (localConstraintWidget.getHeight() < localConstraintWidget.getWrapHeight())) {
        paramArrayOfBoolean[2] = true;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.constraint.solver.widgets.ConstraintWidgetContainer
 * JD-Core Version:    0.7.0.1
 */