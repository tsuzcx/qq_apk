package com.tencent.mm.plugin.appbrand.jsapi.file;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

public final class e$a
{
  static final Map<String, e> gqH;
  
  static
  {
    Object localObject = new HashMap();
    gqH = (Map)localObject;
    ((Map)localObject).put("ascii", new e.a.1());
    gqH.put("base64", new e.a.2());
    gqH.put("hex", new e.a.3());
    localObject = new e.a.4(Charset.forName("ISO-10646-UCS-2"));
    gqH.put("ucs2", localObject);
    gqH.put("ucs-2", localObject);
    localObject = new e.a.5(Charset.forName("UTF-16LE"));
    gqH.put("utf16le", localObject);
    gqH.put("utf-16le", localObject);
    localObject = new e.a.6();
    gqH.put("utf8", localObject);
    gqH.put("utf-8", localObject);
    localObject = new e.a.7();
    gqH.put("latin1", localObject);
    gqH.put("binary", localObject);
  }
  
  static void init() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.e.a
 * JD-Core Version:    0.7.0.1
 */