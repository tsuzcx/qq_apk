package com.tencent.mm.plugin.expt.hellhound.a.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.v;
import java.lang.reflect.Field;
import java.util.List;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RefreshLoadMoreCallback;", "", "()V", "hasMore_Field", "Ljava/lang/reflect/Field;", "incrementList_Field", "isNeedClear_Field", "lastBuffer_Field", "pullType_Field", "getArgsOnFetchDone", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RefreshLoadMoreCallback$ArgsOnFetchDone;", "args", "", "([Ljava/lang/Object;)Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RefreshLoadMoreCallback$ArgsOnFetchDone;", "startMonitor", "", "ArgsOnFetchDone", "Companion", "FinderPullType", "plugin-expt_release"})
public final class l
{
  public static final b qWP;
  private Field qWK;
  private Field qWL;
  private Field qWM;
  private Field qWN;
  private Field qWO;
  
  static
  {
    AppMethodBeat.i(210853);
    qWP = new b((byte)0);
    AppMethodBeat.o(210853);
  }
  
  public l()
  {
    AppMethodBeat.i(210852);
    try
    {
      Object localObject = Class.forName("com.tencent.mm.plugin.finder.feed.model.internal.IResponse");
      Field localField = ((Class)localObject).getDeclaredField("incrementList");
      p.g(localField, "clazz.getDeclaredField(\"incrementList\")");
      this.qWK = localField;
      localField = this.qWK;
      if (localField == null) {
        p.bcb("incrementList_Field");
      }
      localField.setAccessible(true);
      localField = ((Class)localObject).getDeclaredField("lastBuffer");
      p.g(localField, "clazz.getDeclaredField(\"lastBuffer\")");
      this.qWL = localField;
      localField = this.qWL;
      if (localField == null) {
        p.bcb("lastBuffer_Field");
      }
      localField.setAccessible(true);
      localField = ((Class)localObject).getDeclaredField("pullType");
      p.g(localField, "clazz.getDeclaredField(\"pullType\")");
      this.qWM = localField;
      localField = this.qWM;
      if (localField == null) {
        p.bcb("pullType_Field");
      }
      localField.setAccessible(true);
      localField = ((Class)localObject).getDeclaredField("hasMore");
      p.g(localField, "clazz.getDeclaredField(\"hasMore\")");
      this.qWN = localField;
      localField = this.qWN;
      if (localField == null) {
        p.bcb("hasMore_Field");
      }
      localField.setAccessible(true);
      localObject = ((Class)localObject).getDeclaredField("isNeedClear");
      p.g(localObject, "clazz.getDeclaredField(\"isNeedClear\")");
      this.qWO = ((Field)localObject);
      localObject = this.qWO;
      if (localObject == null) {
        p.bcb("isNeedClear_Field");
      }
      ((Field)localObject).setAccessible(true);
      AppMethodBeat.o(210852);
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("HABBYGE-MALI.RefreshLoadMoreCallback", (Throwable)localException, "init crash: " + localException.getMessage(), new Object[0]);
      AppMethodBeat.o(210852);
    }
  }
  
  public final a q(Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(210851);
    p.h(paramArrayOfObject, "args");
    Object localObject1 = paramArrayOfObject[0];
    try
    {
      paramArrayOfObject = this.qWK;
      if (paramArrayOfObject == null) {
        p.bcb("incrementList_Field");
      }
      paramArrayOfObject = paramArrayOfObject.get(localObject1);
      if (paramArrayOfObject == null)
      {
        paramArrayOfObject = new v("null cannot be cast to non-null type kotlin.collections.List<*>");
        AppMethodBeat.o(210851);
        throw paramArrayOfObject;
      }
    }
    catch (Exception paramArrayOfObject)
    {
      ad.printErrStackTrace("HABBYGE-MALI.RefreshLoadMoreCallback", (Throwable)paramArrayOfObject, "getArgsOnFetchDone crash: " + paramArrayOfObject.getMessage(), new Object[0]);
      AppMethodBeat.o(210851);
      return null;
    }
    List localList = (List)paramArrayOfObject;
    paramArrayOfObject = this.qWL;
    if (paramArrayOfObject == null) {
      p.bcb("lastBuffer_Field");
    }
    paramArrayOfObject = paramArrayOfObject.get(localObject1);
    if (paramArrayOfObject == null) {}
    for (paramArrayOfObject = null;; paramArrayOfObject = (b)paramArrayOfObject)
    {
      localObject2 = this.qWM;
      if (localObject2 == null) {
        p.bcb("pullType_Field");
      }
      localObject2 = ((Field)localObject2).get(localObject1);
      if (localObject2 != null) {
        break;
      }
      paramArrayOfObject = new v("null cannot be cast to non-null type kotlin.Int");
      AppMethodBeat.o(210851);
      throw paramArrayOfObject;
    }
    int i = ((Integer)localObject2).intValue();
    Object localObject2 = this.qWN;
    if (localObject2 == null) {
      p.bcb("hasMore_Field");
    }
    localObject2 = ((Field)localObject2).get(localObject1);
    if (localObject2 == null)
    {
      paramArrayOfObject = new v("null cannot be cast to non-null type kotlin.Boolean");
      AppMethodBeat.o(210851);
      throw paramArrayOfObject;
    }
    boolean bool = ((Boolean)localObject2).booleanValue();
    localObject2 = this.qWO;
    if (localObject2 == null) {
      p.bcb("isNeedClear_Field");
    }
    localObject1 = ((Field)localObject2).get(localObject1);
    if (localObject1 == null)
    {
      paramArrayOfObject = new v("null cannot be cast to non-null type kotlin.Boolean");
      AppMethodBeat.o(210851);
      throw paramArrayOfObject;
    }
    paramArrayOfObject = new a(localList, paramArrayOfObject, i, bool, ((Boolean)localObject1).booleanValue());
    AppMethodBeat.o(210851);
    return paramArrayOfObject;
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RefreshLoadMoreCallback$ArgsOnFetchDone;", "", "incrementList", "", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "pullType", "", "hasMore", "", "isNeedClear", "(Ljava/util/List;Lcom/tencent/mm/protobuf/ByteString;IZZ)V", "getHasMore", "()Z", "setHasMore", "(Z)V", "getIncrementList", "()Ljava/util/List;", "setIncrementList", "(Ljava/util/List;)V", "setNeedClear", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "setLastBuffer", "(Lcom/tencent/mm/protobuf/ByteString;)V", "getPullType", "()I", "setPullType", "(I)V", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "", "plugin-expt_release"})
  public static final class a
  {
    private boolean hasMore;
    public List<?> incrementList;
    private boolean isNeedClear;
    private b lastBuffer;
    public int pullType;
    
    public a(List<?> paramList, b paramb, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
    {
      this.incrementList = paramList;
      this.lastBuffer = paramb;
      this.pullType = paramInt;
      this.hasMore = paramBoolean1;
      this.isNeedClear = paramBoolean2;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(210847);
      if (this != paramObject)
      {
        if ((paramObject instanceof a))
        {
          paramObject = (a)paramObject;
          if ((!p.i(this.incrementList, paramObject.incrementList)) || (!p.i(this.lastBuffer, paramObject.lastBuffer)) || (this.pullType != paramObject.pullType) || (this.hasMore != paramObject.hasMore) || (this.isNeedClear != paramObject.isNeedClear)) {}
        }
      }
      else
      {
        AppMethodBeat.o(210847);
        return true;
      }
      AppMethodBeat.o(210847);
      return false;
    }
    
    public final int hashCode()
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    public final String toString()
    {
      AppMethodBeat.i(210845);
      String str = "ArgsOnFetchDone(incrementList=" + this.incrementList + ", lastBuffer=" + this.lastBuffer + ", pullType=" + this.pullType + ", hasMore=" + this.hasMore + ", isNeedClear=" + this.isNeedClear + ")";
      AppMethodBeat.o(210845);
      return str;
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RefreshLoadMoreCallback$Companion;", "", "()V", "TAG", "", "plugin-expt_release"})
  public static final class b {}
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RefreshLoadMoreCallback$FinderPullType;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "PULL_TYPE_ENTER", "PULL_TYPE_TOP", "PULL_TYPE_BOTTOM", "PULL_TYPE_PRE_FETCH", "PULL_TYPE_REFRESH", "plugin-expt_release"})
  public static enum c
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(210848);
      c localc1 = new c("PULL_TYPE_ENTER", 0, 0);
      qWQ = localc1;
      c localc2 = new c("PULL_TYPE_TOP", 1, 1);
      qWR = localc2;
      c localc3 = new c("PULL_TYPE_BOTTOM", 2, 2);
      qWS = localc3;
      c localc4 = new c("PULL_TYPE_PRE_FETCH", 3, 3);
      qWT = localc4;
      c localc5 = new c("PULL_TYPE_REFRESH", 4, 4);
      qWU = localc5;
      qWV = new c[] { localc1, localc2, localc3, localc4, localc5 };
      AppMethodBeat.o(210848);
    }
    
    private c(int paramInt)
    {
      this.value = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.b.l
 * JD-Core Version:    0.7.0.1
 */