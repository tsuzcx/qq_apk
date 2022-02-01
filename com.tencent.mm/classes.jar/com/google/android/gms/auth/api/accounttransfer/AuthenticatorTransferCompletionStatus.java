package com.google.android.gms.auth.api.accounttransfer;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface AuthenticatorTransferCompletionStatus
{
  public static final int COMPLETED_FAILURE = 2;
  public static final int COMPLETED_SUCCESS = 1;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.gms.auth.api.accounttransfer.AuthenticatorTransferCompletionStatus
 * JD-Core Version:    0.7.0.1
 */