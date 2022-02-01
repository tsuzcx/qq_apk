package com.tencent.matrix.resource.processor;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.matrix.report.e;
import com.tencent.matrix.resource.CanaryWorkerService;
import com.tencent.matrix.resource.analyzer.model.DestroyedActivityInfo;
import com.tencent.matrix.resource.analyzer.model.d;
import com.tencent.matrix.resource.analyzer.model.d.a;
import com.tencent.matrix.resource.analyzer.model.g;
import com.tencent.matrix.resource.b.a.b;
import com.tencent.matrix.resource.c.a.a;
import java.io.File;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class b
{
  final com.tencent.matrix.resource.f.b daQ;
  private com.tencent.matrix.resource.c.b dcP;
  private com.tencent.matrix.resource.c.a ddO;
  private a.a ddP;
  
  public b(com.tencent.matrix.resource.f.b paramb)
  {
    this.daQ = paramb;
  }
  
  protected static com.tencent.matrix.resource.analyzer.model.a g(File paramFile, String paramString)
  {
    d locald = com.tencent.matrix.resource.analyzer.model.c.n(Build.VERSION.SDK_INT, Build.MANUFACTURER).XB();
    try
    {
      paramFile = new g(paramFile);
      paramString = new com.tencent.matrix.resource.analyzer.a(paramString, locald);
      paramFile = paramString.a(paramFile, paramString.daR);
      return paramFile;
    }
    catch (IOException paramFile) {}
    return com.tencent.matrix.resource.analyzer.model.a.a(paramFile, 0L);
  }
  
  public final com.tencent.matrix.resource.c.a XL()
  {
    if (this.ddO == null)
    {
      Context localContext = this.daQ.mContext;
      if (this.dcP == null) {
        this.dcP = new com.tencent.matrix.resource.c.b(this.daQ.mContext);
      }
      this.ddO = new com.tencent.matrix.resource.c.a(localContext, this.dcP);
    }
    return this.ddO;
  }
  
  protected final a.a XM()
  {
    if (this.ddP == null) {
      this.ddP = new a.a()
      {
        public final void a(com.tencent.matrix.resource.analyzer.model.f paramAnonymousf)
        {
          CanaryWorkerService.a(b.this.daQ.mContext, paramAnonymousf);
        }
      };
    }
    return this.ddP;
  }
  
  protected final void a(int paramInt, a.b paramb, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    com.tencent.matrix.report.f localf = new com.tencent.matrix.report.f(paramInt);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("dump_mode", paramb.name());
      localJSONObject.put("activity", paramString1);
      localJSONObject.put("ref_key", paramString2);
      localJSONObject.put("leak_detail", paramString3);
      localJSONObject.put("cost_millis", paramString4);
      localf.cZZ = localJSONObject;
      this.daQ.ded.onDetectIssue(localf);
      return;
    }
    catch (JSONException paramb)
    {
      for (;;)
      {
        com.tencent.matrix.e.c.printErrStackTrace("Matrix.LeakProcessor.Base", paramb, "", new Object[0]);
      }
    }
  }
  
  public abstract boolean a(DestroyedActivityInfo paramDestroyedActivityInfo);
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.resource.processor.b
 * JD-Core Version:    0.7.0.1
 */