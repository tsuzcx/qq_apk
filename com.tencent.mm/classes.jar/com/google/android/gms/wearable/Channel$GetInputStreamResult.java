package com.google.android.gms.wearable;

import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import java.io.InputStream;

public abstract interface Channel$GetInputStreamResult
  extends Releasable, Result
{
  public abstract InputStream getInputStream();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.gms.wearable.Channel.GetInputStreamResult
 * JD-Core Version:    0.7.0.1
 */