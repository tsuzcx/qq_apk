package com.google.android.gms.wearable;

import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import java.io.InputStream;
import javax.annotation.Nullable;

@Deprecated
public abstract interface Channel$GetInputStreamResult
  extends Releasable, Result
{
  @Nullable
  public abstract InputStream getInputStream();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.wearable.Channel.GetInputStreamResult
 * JD-Core Version:    0.7.0.1
 */