package com.tencent.mm.plugin.ad.a;

import android.os.AsyncTask;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.sdk.platformtools.y;

final class a$b
  extends AsyncTask<String, Integer, d>
{
  a$b(a parama) {}
  
  private d y(String... paramVarArgs)
  {
    Object localObject4 = null;
    Object localObject3 = null;
    y.d("dktest", "doInBackground :" + paramVarArgs);
    if ((paramVarArgs == null) || (paramVarArgs.length != 1)) {
      return null;
    }
    Object localObject1 = localObject3;
    Object localObject2 = localObject4;
    try
    {
      this.njY.njX = System.currentTimeMillis();
      localObject1 = localObject3;
      localObject2 = localObject4;
      g.a locala = new g.a();
      localObject1 = localObject3;
      localObject2 = localObject4;
      paramVarArgs = this.njY.Lu(paramVarArgs[0]);
      localObject1 = paramVarArgs;
      localObject2 = paramVarArgs;
      y.d("MicroMsg.scanner.DecodeFile", "time: " + locala.zJ());
      return paramVarArgs;
    }
    catch (OutOfMemoryError paramVarArgs)
    {
      y.e("MicroMsg.scanner.DecodeFile", "decode failed, OutOfMemoryError");
      return localObject1;
    }
    catch (Exception paramVarArgs)
    {
      y.printErrStackTrace("MicroMsg.scanner.DecodeFile", paramVarArgs, "decode failed due to Exception", new Object[] { "" });
    }
    return localObject2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ad.a.a.b
 * JD-Core Version:    0.7.0.1
 */