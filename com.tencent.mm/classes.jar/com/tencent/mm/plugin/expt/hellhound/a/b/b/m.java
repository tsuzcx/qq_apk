package com.tencent.mm.plugin.expt.hellhound.a.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.reflect.Field;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RefreshLoadMoreCallback;", "", "()V", "hasMore_Field", "Ljava/lang/reflect/Field;", "incrementList_Field", "isNeedClear_Field", "lastBuffer_Field", "pullType_Field", "getArgsOnFetchDone", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RefreshLoadMoreCallback$ArgsOnFetchDone;", "args", "", "([Ljava/lang/Object;)Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RefreshLoadMoreCallback$ArgsOnFetchDone;", "startMonitor", "", "ArgsOnFetchDone", "Companion", "FinderPullType", "plugin-expt_release"})
public final class m
{
  public static final b wmd;
  private Field wlY;
  private Field wlZ;
  private Field wma;
  private Field wmb;
  private Field wmc;
  
  static
  {
    AppMethodBeat.i(254124);
    wmd = new b((byte)0);
    AppMethodBeat.o(254124);
  }
  
  public m()
  {
    AppMethodBeat.i(254123);
    try
    {
      Object localObject = Class.forName("com.tencent.mm.plugin.finder.feed.model.internal.IResponse");
      p.j(localObject, "Class.forName(\"com.tence…odel.internal.IResponse\")");
      Field localField = ((Class)localObject).getDeclaredField("incrementList");
      p.j(localField, "clazz.getDeclaredField(\"incrementList\")");
      this.wlY = localField;
      localField = this.wlY;
      if (localField == null) {
        p.bGy("incrementList_Field");
      }
      localField.setAccessible(true);
      localField = ((Class)localObject).getDeclaredField("lastBuffer");
      p.j(localField, "clazz.getDeclaredField(\"lastBuffer\")");
      this.wlZ = localField;
      localField = this.wlZ;
      if (localField == null) {
        p.bGy("lastBuffer_Field");
      }
      localField.setAccessible(true);
      localField = ((Class)localObject).getDeclaredField("pullType");
      p.j(localField, "clazz.getDeclaredField(\"pullType\")");
      this.wma = localField;
      localField = this.wma;
      if (localField == null) {
        p.bGy("pullType_Field");
      }
      localField.setAccessible(true);
      localField = ((Class)localObject).getDeclaredField("hasMore");
      p.j(localField, "clazz.getDeclaredField(\"hasMore\")");
      this.wmb = localField;
      localField = this.wmb;
      if (localField == null) {
        p.bGy("hasMore_Field");
      }
      localField.setAccessible(true);
      localObject = ((Class)localObject).getDeclaredField("isNeedClear");
      p.j(localObject, "clazz.getDeclaredField(\"isNeedClear\")");
      this.wmc = ((Field)localObject);
      localObject = this.wmc;
      if (localObject == null) {
        p.bGy("isNeedClear_Field");
      }
      ((Field)localObject).setAccessible(true);
      AppMethodBeat.o(254123);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("HABBYGE-MALI.RefreshLoadMoreCallback", (Throwable)localException, "init crash: " + localException.getMessage(), new Object[0]);
      AppMethodBeat.o(254123);
    }
  }
  
  public final a p(Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(254121);
    p.k(paramArrayOfObject, "args");
    Object localObject2 = paramArrayOfObject[0];
    Object localObject1;
    for (;;)
    {
      try
      {
        paramArrayOfObject = this.wlY;
        if (paramArrayOfObject == null) {
          p.bGy("incrementList_Field");
        }
        localObject1 = paramArrayOfObject.get(localObject2);
        paramArrayOfObject = (Object[])localObject1;
        if (!(localObject1 instanceof List)) {
          paramArrayOfObject = null;
        }
        localObject1 = (List)paramArrayOfObject;
        paramArrayOfObject = this.wlZ;
        if (paramArrayOfObject == null) {
          p.bGy("lastBuffer_Field");
        }
        paramArrayOfObject = paramArrayOfObject.get(localObject2);
        if (paramArrayOfObject == null)
        {
          paramArrayOfObject = null;
          localObject3 = this.wma;
          if (localObject3 == null) {
            p.bGy("pullType_Field");
          }
          localObject3 = ((Field)localObject3).get(localObject2);
          if (localObject3 != null) {
            break;
          }
          paramArrayOfObject = new t("null cannot be cast to non-null type kotlin.Int");
          AppMethodBeat.o(254121);
          throw paramArrayOfObject;
        }
      }
      catch (Exception paramArrayOfObject)
      {
        Log.printErrStackTrace("HABBYGE-MALI.RefreshLoadMoreCallback", (Throwable)paramArrayOfObject, "getArgsOnFetchDone crash: " + paramArrayOfObject.getMessage(), new Object[0]);
        AppMethodBeat.o(254121);
        return null;
      }
      paramArrayOfObject = (b)paramArrayOfObject;
    }
    int i = ((Integer)localObject3).intValue();
    Object localObject3 = this.wmb;
    if (localObject3 == null) {
      p.bGy("hasMore_Field");
    }
    localObject3 = ((Field)localObject3).get(localObject2);
    if (localObject3 == null)
    {
      paramArrayOfObject = new t("null cannot be cast to non-null type kotlin.Boolean");
      AppMethodBeat.o(254121);
      throw paramArrayOfObject;
    }
    boolean bool = ((Boolean)localObject3).booleanValue();
    localObject3 = this.wmc;
    if (localObject3 == null) {
      p.bGy("isNeedClear_Field");
    }
    localObject2 = ((Field)localObject3).get(localObject2);
    if (localObject2 == null)
    {
      paramArrayOfObject = new t("null cannot be cast to non-null type kotlin.Boolean");
      AppMethodBeat.o(254121);
      throw paramArrayOfObject;
    }
    paramArrayOfObject = new a((List)localObject1, paramArrayOfObject, i, bool, ((Boolean)localObject2).booleanValue());
    AppMethodBeat.o(254121);
    return paramArrayOfObject;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RefreshLoadMoreCallback$ArgsOnFetchDone;", "", "incrementList", "", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "pullType", "", "hasMore", "", "isNeedClear", "(Ljava/util/List;Lcom/tencent/mm/protobuf/ByteString;IZZ)V", "getHasMore", "()Z", "setHasMore", "(Z)V", "getIncrementList", "()Ljava/util/List;", "setIncrementList", "(Ljava/util/List;)V", "setNeedClear", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "setLastBuffer", "(Lcom/tencent/mm/protobuf/ByteString;)V", "getPullType", "()I", "setPullType", "(I)V", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "", "plugin-expt_release"})
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
      AppMethodBeat.i(253246);
      if (this != paramObject)
      {
        if ((paramObject instanceof a))
        {
          paramObject = (a)paramObject;
          if ((!p.h(this.incrementList, paramObject.incrementList)) || (!p.h(this.lastBuffer, paramObject.lastBuffer)) || (this.pullType != paramObject.pullType) || (this.hasMore != paramObject.hasMore) || (this.isNeedClear != paramObject.isNeedClear)) {}
        }
      }
      else
      {
        AppMethodBeat.o(253246);
        return true;
      }
      AppMethodBeat.o(253246);
      return false;
    }
    
    public final int hashCode()
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    public final String toString()
    {
      AppMethodBeat.i(253243);
      String str = "ArgsOnFetchDone(incrementList=" + this.incrementList + ", lastBuffer=" + this.lastBuffer + ", pullType=" + this.pullType + ", hasMore=" + this.hasMore + ", isNeedClear=" + this.isNeedClear + ")";
      AppMethodBeat.o(253243);
      return str;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RefreshLoadMoreCallback$Companion;", "", "()V", "TAG", "", "plugin-expt_release"})
  public static final class b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.b.m
 * JD-Core Version:    0.7.0.1
 */