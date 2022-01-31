package com.google.android.gms.wearable;

import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import java.io.OutputStream;
import javax.annotation.Nullable;

@Deprecated
public abstract interface Channel$GetOutputStreamResult
  extends Releasable, Result
{
  @Nullable
  public abstract OutputStream getOutputStream();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.gms.wearable.Channel.GetOutputStreamResult
 * JD-Core Version:    0.7.0.1
 */