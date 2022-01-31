package com.tencent.mm.booter.notification.queue;

import com.tencent.mm.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.URLDecoder;
import java.net.URLEncoder;

public final class c
{
  public static String a(Serializable paramSerializable)
  {
    long l = System.currentTimeMillis();
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    ObjectOutputStream localObjectOutputStream = new ObjectOutputStream(localByteArrayOutputStream);
    localObjectOutputStream.writeObject(paramSerializable);
    paramSerializable = URLEncoder.encode(localByteArrayOutputStream.toString("ISO-8859-1"), "UTF-8");
    localObjectOutputStream.close();
    localByteArrayOutputStream.close();
    y.d("MicroMsg.NotificationQueueTool", "serialize consume: %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    return paramSerializable;
  }
  
  public static Serializable eA(String paramString)
  {
    if (ah.bl(paramString)) {
      return null;
    }
    long l = System.currentTimeMillis();
    paramString = new ByteArrayInputStream(URLDecoder.decode(paramString, "UTF-8").getBytes("ISO-8859-1"));
    ObjectInputStream localObjectInputStream = new ObjectInputStream(paramString);
    Serializable localSerializable = (Serializable)localObjectInputStream.readObject();
    localObjectInputStream.close();
    paramString.close();
    y.d("MicroMsg.NotificationQueueTool", "de serialize consume: %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    return localSerializable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.booter.notification.queue.c
 * JD-Core Version:    0.7.0.1
 */