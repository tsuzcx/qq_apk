package com.tencent.mm.o;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.f;
import com.tencent.mm.am.f.a;
import com.tencent.mm.am.f.b;
import com.tencent.mm.am.g;
import com.tencent.mm.am.g.a;
import com.tencent.mm.am.g.c;
import com.tencent.mm.am.g.d;
import com.tencent.mm.api.j;
import com.tencent.mm.api.u;
import com.tencent.mm.model.cn;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.protocal.protobuf.dl;
import com.tencent.mm.protocal.protobuf.tb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bu;
import java.util.Iterator;
import java.util.List;

public final class a
  implements u
{
  private static dl b(dl paramdl)
  {
    boolean bool = true;
    AppMethodBeat.i(114095);
    if (paramdl == null)
    {
      AppMethodBeat.o(114095);
      return null;
    }
    Object localObject = paramdl.YFE;
    int i = paramdl.IIs;
    if (paramdl.YFG == null) {}
    for (;;)
    {
      Log.i("FunctionMsg.FunctionMsgDispatcher", "processAddMsg, fromUser: %s, msgType: %s, content==null: %s", new Object[] { localObject, Integer.valueOf(i), Boolean.valueOf(bool) });
      localObject = Util.nullAsNil(w.a(paramdl.YFE));
      if ("readerapp".equals(localObject))
      {
        paramdl.YFE = w.Sk("newsapp");
        paramdl.IIs = 12399999;
      }
      if (("blogapp".equals(localObject)) || ("newsapp".equals(localObject))) {
        paramdl.IIs = 12399999;
      }
      AppMethodBeat.o(114095);
      return paramdl;
      bool = false;
    }
  }
  
  public final void a(String paramString, j paramj, dl paramdl)
  {
    AppMethodBeat.i(114097);
    Log.i("FunctionMsg.FunctionMsgDispatcher", "[onFunctionMsgDelete] item:%s", new Object[] { paramj });
    try
    {
      b(paramdl);
      paramdl.CreateTime = ((int)paramj.field_actionTime);
      paramj.a(paramdl);
      paramj.field_status = 100;
      bu localbu = bu.adkj;
      bu.a(paramString, paramj);
      g.d.dB(Integer.valueOf(paramdl.IIs)).b(new g.c(paramdl, paramString, paramj));
      AppMethodBeat.o(114097);
      return;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("FunctionMsg.FunctionMsgDispatcher", paramString, "", new Object[0]);
      AppMethodBeat.o(114097);
    }
  }
  
  public final void a(String paramString, j paramj, dl paramdl, List<dl> paramList)
  {
    AppMethodBeat.i(233804);
    Object localObject;
    for (;;)
    {
      try
      {
        b(paramdl);
        if (paramj.field_businessInfo != null)
        {
          localObject = f.a.iz(paramj.field_businessInfo.YYv);
          if (localObject != null) {
            ((f)localObject).aTn();
          }
        }
        localObject = new f.b();
        ((f.b)localObject).otK = paramj.field_businessInfo;
        ((f.b)localObject).otL = paramj.field_functionmsgid;
        if (paramj.field_actionTime == 0L)
        {
          l = cn.bDu() / 1000L;
          paramdl.CreateTime = ((int)l);
          paramj.field_status = 100;
          paramj.a(paramdl);
          bu localbu = bu.adkj;
          bu.a(paramString, paramj);
          Log.i("FunctionMsg.FunctionMsgDispatcher", "[onFunctionMsgAdd] item:%s CreateTime:%s", new Object[] { paramj, Integer.valueOf(paramdl.CreateTime) });
          if ((paramList == null) || (paramList.size() <= 0)) {
            break label312;
          }
          Log.i("FunctionMsg.FunctionMsgDispatcher", "[onFunctionMsgAdd] addMsgList.size:%s ", new Object[] { Integer.valueOf(paramList.size()) });
          paramString = paramList.iterator();
          if (!paramString.hasNext()) {
            break;
          }
          paramdl = (dl)paramString.next();
          if (paramdl.CreateTime <= 0L)
          {
            if (paramj.field_actionTime != 0L) {
              break label297;
            }
            l = cn.bDu() / 1000L;
            paramdl.CreateTime = ((int)l);
          }
          g.d.dB(Integer.valueOf(paramdl.IIs)).b(new g.a(paramdl, localObject));
          continue;
        }
        l = paramj.field_actionTime;
      }
      catch (Exception paramString)
      {
        Log.printErrStackTrace("FunctionMsg.FunctionMsgDispatcher", paramString, "", new Object[0]);
        AppMethodBeat.o(233804);
        return;
      }
      continue;
      label297:
      long l = paramj.field_actionTime;
    }
    AppMethodBeat.o(233804);
    return;
    label312:
    paramString = g.d.dB(Integer.valueOf(paramdl.IIs));
    if (paramString != null) {
      paramString.b(new g.a(paramdl, localObject));
    }
    AppMethodBeat.o(233804);
  }
  
  public final void a(String paramString, tb paramtb)
  {
    AppMethodBeat.i(233806);
    try
    {
      f.b localb = new f.b();
      localb.otL = paramString;
      localb.otK = paramtb;
      if (paramtb != null)
      {
        paramString = f.a.iz((int)paramtb.YYv);
        if (paramString != null)
        {
          paramString.a(localb);
          paramtb.YYw = localb.otK.YYw;
        }
      }
      AppMethodBeat.o(233806);
      return;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("FunctionMsg.FunctionMsgDispatcher", paramString, "", new Object[0]);
      AppMethodBeat.o(233806);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.o.a
 * JD-Core Version:    0.7.0.1
 */