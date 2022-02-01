package com.tencent.mm.plugin.expt.hellhound.ext.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.reflect.Field;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RefreshLoadMoreCallback;", "", "()V", "hasMore_Field", "Ljava/lang/reflect/Field;", "incrementList_Field", "isNeedClear_Field", "lastBuffer_Field", "pullType_Field", "getArgsOnFetchDone", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RefreshLoadMoreCallback$ArgsOnFetchDone;", "args", "", "([Ljava/lang/Object;)Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RefreshLoadMoreCallback$ArgsOnFetchDone;", "startMonitor", "", "ArgsOnFetchDone", "Companion", "FinderPullType", "plugin-expt_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class m
{
  public static final m.b zId;
  private Field zIe;
  private Field zIf;
  private Field zIg;
  private Field zIh;
  private Field zIi;
  
  static
  {
    AppMethodBeat.i(300579);
    zId = new m.b((byte)0);
    AppMethodBeat.o(300579);
  }
  
  public m()
  {
    AppMethodBeat.i(300572);
    try
    {
      Class localClass = Class.forName("com.tencent.mm.plugin.finder.feed.model.internal.IResponse");
      Object localObject1 = localClass.getDeclaredField("incrementList");
      s.s(localObject1, "clazz.getDeclaredField(\"incrementList\")");
      this.zIe = ((Field)localObject1);
      Field localField = this.zIe;
      localObject1 = localField;
      if (localField == null)
      {
        s.bIx("incrementList_Field");
        localObject1 = null;
      }
      ((Field)localObject1).setAccessible(true);
      localObject1 = localClass.getDeclaredField("lastBuffer");
      s.s(localObject1, "clazz.getDeclaredField(\"lastBuffer\")");
      this.zIf = ((Field)localObject1);
      localField = this.zIf;
      localObject1 = localField;
      if (localField == null)
      {
        s.bIx("lastBuffer_Field");
        localObject1 = null;
      }
      ((Field)localObject1).setAccessible(true);
      localObject1 = localClass.getDeclaredField("pullType");
      s.s(localObject1, "clazz.getDeclaredField(\"pullType\")");
      this.zIg = ((Field)localObject1);
      localField = this.zIg;
      localObject1 = localField;
      if (localField == null)
      {
        s.bIx("pullType_Field");
        localObject1 = null;
      }
      ((Field)localObject1).setAccessible(true);
      localObject1 = localClass.getDeclaredField("hasMore");
      s.s(localObject1, "clazz.getDeclaredField(\"hasMore\")");
      this.zIh = ((Field)localObject1);
      localField = this.zIh;
      localObject1 = localField;
      if (localField == null)
      {
        s.bIx("hasMore_Field");
        localObject1 = null;
      }
      ((Field)localObject1).setAccessible(true);
      localObject1 = localClass.getDeclaredField("isNeedClear");
      s.s(localObject1, "clazz.getDeclaredField(\"isNeedClear\")");
      this.zIi = ((Field)localObject1);
      localObject1 = this.zIi;
      if (localObject1 == null)
      {
        s.bIx("isNeedClear_Field");
        localObject1 = localObject2;
      }
      for (;;)
      {
        ((Field)localObject1).setAccessible(true);
        AppMethodBeat.o(300572);
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("HABBYGE-MALI.RefreshLoadMoreCallback", (Throwable)localException, s.X("init crash: ", localException.getMessage()), new Object[0]);
      AppMethodBeat.o(300572);
    }
  }
  
  public final m.a r(Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(300584);
    s.u(paramArrayOfObject, "args");
    Object localObject3 = paramArrayOfObject[0];
    Object localObject1;
    for (;;)
    {
      try
      {
        localObject1 = this.zIe;
        paramArrayOfObject = (Object[])localObject1;
        if (localObject1 == null)
        {
          s.bIx("incrementList_Field");
          paramArrayOfObject = null;
        }
        paramArrayOfObject = paramArrayOfObject.get(localObject3);
        if ((paramArrayOfObject instanceof List))
        {
          paramArrayOfObject = (List)paramArrayOfObject;
          localObject2 = this.zIf;
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            s.bIx("lastBuffer_Field");
            localObject1 = null;
          }
          localObject1 = ((Field)localObject1).get(localObject3);
          if (localObject1 != null) {
            break label185;
          }
          localObject1 = null;
          localField = this.zIg;
          localObject2 = localField;
          if (localField == null)
          {
            s.bIx("pullType_Field");
            localObject2 = null;
          }
          localObject2 = ((Field)localObject2).get(localObject3);
          if (localObject2 != null) {
            break;
          }
          paramArrayOfObject = new NullPointerException("null cannot be cast to non-null type kotlin.Int");
          AppMethodBeat.o(300584);
          throw paramArrayOfObject;
        }
      }
      catch (Exception paramArrayOfObject)
      {
        Log.printErrStackTrace("HABBYGE-MALI.RefreshLoadMoreCallback", (Throwable)paramArrayOfObject, s.X("getArgsOnFetchDone crash: ", paramArrayOfObject.getMessage()), new Object[0]);
        AppMethodBeat.o(300584);
        return null;
      }
      paramArrayOfObject = null;
      continue;
      label185:
      localObject1 = (b)localObject1;
    }
    int i = ((Integer)localObject2).intValue();
    Field localField = this.zIh;
    Object localObject2 = localField;
    if (localField == null)
    {
      s.bIx("hasMore_Field");
      localObject2 = null;
    }
    localObject2 = ((Field)localObject2).get(localObject3);
    if (localObject2 == null)
    {
      paramArrayOfObject = new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
      AppMethodBeat.o(300584);
      throw paramArrayOfObject;
    }
    boolean bool = ((Boolean)localObject2).booleanValue();
    localField = this.zIi;
    localObject2 = localField;
    if (localField == null)
    {
      s.bIx("isNeedClear_Field");
      localObject2 = null;
    }
    localObject2 = ((Field)localObject2).get(localObject3);
    if (localObject2 == null)
    {
      paramArrayOfObject = new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
      AppMethodBeat.o(300584);
      throw paramArrayOfObject;
    }
    paramArrayOfObject = new m.a(paramArrayOfObject, (b)localObject1, i, bool, ((Boolean)localObject2).booleanValue());
    AppMethodBeat.o(300584);
    return paramArrayOfObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.ext.b.b.m
 * JD-Core Version:    0.7.0.1
 */