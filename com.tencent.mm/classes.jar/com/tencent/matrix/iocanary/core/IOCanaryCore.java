package com.tencent.matrix.iocanary.core;

import com.tencent.matrix.e.c;
import com.tencent.matrix.report.g;
import com.tencent.matrix.report.h.a;
import java.util.List;

public class IOCanaryCore
  implements OnJniIssuePublishListener, h.a
{
  private static final String TAG = "Matrix.IOCanaryCore";
  private com.tencent.matrix.iocanary.b.a mCloseGuardHooker;
  private final com.tencent.matrix.iocanary.a.a mIOConfig;
  private final com.tencent.matrix.iocanary.a mIoCanaryPlugin;
  private boolean mIsStart;
  
  static
  {
    if (!IOCanaryCore.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public IOCanaryCore(com.tencent.matrix.iocanary.a parama)
  {
    this.mIOConfig = parama.mIOConfig;
    this.mIoCanaryPlugin = parama;
  }
  
  private void initDetectorsAndHookers(com.tencent.matrix.iocanary.a.a parama)
  {
    assert (parama != null);
    if ((parama.axO()) || (parama.axQ()) || (parama.axP())) {
      IOCanaryJniBridge.install(parama, this);
    }
    if (parama.axR())
    {
      this.mCloseGuardHooker = new com.tencent.matrix.iocanary.b.a(this);
      parama = this.mCloseGuardHooker;
      c.i("Matrix.CloseGuardHooker", "hook sIsTryHook=%b", new Object[] { Boolean.valueOf(parama.eVu) });
      if (!parama.eVu)
      {
        c.i("Matrix.CloseGuardHooker", "hook hookRet=%b", new Object[] { Boolean.valueOf(parama.axS()) });
        parama.eVu = true;
      }
    }
  }
  
  public boolean isStart()
  {
    try
    {
      boolean bool = this.mIsStart;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void onDetectIssue(g paramg)
  {
    this.mIoCanaryPlugin.onDetectIssue(paramg);
  }
  
  public void onIssuePublish(List<IOIssue> paramList)
  {
    if (paramList == null) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < paramList.size())
      {
        this.mIoCanaryPlugin.onDetectIssue(com.tencent.matrix.iocanary.c.a.a((IOIssue)paramList.get(i)));
        i += 1;
      }
    }
  }
  
  public void start()
  {
    initDetectorsAndHookers(this.mIOConfig);
    try
    {
      this.mIsStart = true;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void stop()
  {
    try
    {
      this.mIsStart = false;
      if (this.mCloseGuardHooker != null)
      {
        com.tencent.matrix.iocanary.b.a locala = this.mCloseGuardHooker;
        c.i("Matrix.CloseGuardHooker", "unHook unHookRet=%b", new Object[] { Boolean.valueOf(com.tencent.matrix.iocanary.b.a.axT()) });
        locala.eVu = false;
      }
      IOCanaryJniBridge.uninstall();
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.matrix.iocanary.core.IOCanaryCore
 * JD-Core Version:    0.7.0.1
 */