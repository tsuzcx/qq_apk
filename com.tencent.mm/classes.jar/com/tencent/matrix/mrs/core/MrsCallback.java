package com.tencent.matrix.mrs.core;

public abstract interface MrsCallback
{
  public abstract String getCryptKey(MatrixUploadDataSlice paramMatrixUploadDataSlice);
  
  public abstract String getHost(MatrixUploadDataSlice paramMatrixUploadDataSlice);
  
  public abstract String getPublicSharePath();
  
  public abstract String getUrl(MatrixUploadDataSlice paramMatrixUploadDataSlice);
  
  public abstract boolean onRequestGetMrsStrategy(byte[] paramArrayOfByte);
  
  public abstract void onStrategyNotify(String paramString, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.matrix.mrs.core.MrsCallback
 * JD-Core Version:    0.7.0.1
 */