package com.tencent.matrix.b;

import com.tencent.matrix.mrs.core.MrsLogic;
import com.tencent.matrix.mrs.core.MrsLogic.PhoneInfo;
import com.tencent.matrix.report.h.c;
import com.tencent.matrix.report.h.d;
import com.tencent.matrix.resource.c.a;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.vfs.i;
import java.io.File;
import java.util.Properties;
import org.json.JSONObject;

public final class c
  implements h.c
{
  public final void a(h.d paramd)
  {
    String str;
    if ("memory".equals(paramd.tag))
    {
      if (paramd.cue == null) {
        break label200;
      }
      str = paramd.cue.optString("resultZipPath");
      if ((str != null) && (str.length() != 0)) {}
    }
    else
    {
      return;
    }
    Properties localProperties = new Properties();
    localProperties.put("Uin", com.tencent.mm.loader.j.c.gMU.aw("last_login_uin", "0"));
    localProperties.put("ClientVersion", String.valueOf(d.DIc));
    localProperties.put("Revision", h.REV);
    localProperties.put("ReportTime", String.valueOf(System.currentTimeMillis()));
    localProperties.put("process", paramd.cue.optString("process"));
    MrsLogic.PhoneInfo localPhoneInfo = MrsLogic.getPhoneInfo();
    localProperties.put("DeviceModel", localPhoneInfo.deviceModel);
    localProperties.put("OSName", localPhoneInfo.osName);
    localProperties.put("OSVersion", localPhoneInfo.osVersion);
    if (a.a(new File(i.k(i.k(str, true), true)), localProperties))
    {
      paramd.filePath = str;
      return;
    }
    com.tencent.matrix.g.c.e("Matrix.MemoryReportListener", "HprofBufferShrinker.addExtraInfo fail, tag:memory", new Object[0]);
    return;
    label200:
    com.tencent.matrix.g.c.e("Matrix.MemoryReportListener", "issue content is null, tag:memory", new Object[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.b.c
 * JD-Core Version:    0.7.0.1
 */