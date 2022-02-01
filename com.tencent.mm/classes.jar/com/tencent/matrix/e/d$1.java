package com.tencent.matrix.e;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

final class d$1
  extends ThreadLocal<MessageDigest>
{
  private static MessageDigest initialValue()
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      return localMessageDigest;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      throw new RuntimeException("Initialize MD5 failed.", localNoSuchAlgorithmException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.matrix.e.d.1
 * JD-Core Version:    0.7.0.1
 */