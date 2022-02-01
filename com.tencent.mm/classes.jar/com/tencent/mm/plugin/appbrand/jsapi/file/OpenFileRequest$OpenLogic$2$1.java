package com.tencent.mm.plugin.appbrand.jsapi.file;

import androidx.lifecycle.j.a;
import androidx.lifecycle.p;
import androidx.lifecycle.z;
import com.tencent.mm.xwebutil.a;
import com.tencent.mm.xwebutil.a.a;

class OpenFileRequest$OpenLogic$2$1
  implements p
{
  OpenFileRequest$OpenLogic$2$1(OpenFileRequest.a.2 param2, a.a parama) {}
  
  @z(Ho=j.a.ON_DESTROY)
  void onActivityDestroyed()
  {
    a.a locala = this.rYc;
    if (locala == null) {}
    while (a.agZv != locala) {
      return;
    }
    a.agZv = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.OpenFileRequest.OpenLogic.2.1
 * JD-Core Version:    0.7.0.1
 */