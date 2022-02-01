package com.tencent.map.geolocation.internal;

import android.util.Pair;
import java.io.IOException;

public abstract interface TencentHttpClient
{
  public abstract Pair<byte[], String> postSync(String paramString, byte[] paramArrayOfByte)
    throws IOException;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.map.geolocation.internal.TencentHttpClient
 * JD-Core Version:    0.7.0.1
 */