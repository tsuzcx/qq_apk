package com.tencent.matrix.memguard;

import java.util.Arrays;

public final class MemGuard$Options
{
  public boolean ignoreOverlappedReading;
  public String[] ignoredSOPatterns;
  public String issueDumpFilePath;
  public int maxAllocationSize;
  public int maxDetectableAllocationCount;
  public int maxSkippedAllocationCount;
  public int percentageOfLeftSideGuard;
  public boolean perfectRightSideGuard;
  public String[] targetSOPatterns;
  
  public final String toString()
  {
    return "Options{maxAllocationSize=" + this.maxAllocationSize + ", maxDetectableAllocationCount=" + this.maxDetectableAllocationCount + ", maxSkippedAllocationCount=" + this.maxSkippedAllocationCount + ", percentageOfLeftSideGuard=" + this.percentageOfLeftSideGuard + ", perfectRightSideGuard=" + this.perfectRightSideGuard + ", ignoreOverlappedReading=" + this.ignoreOverlappedReading + ", issueDumpFilePath=" + this.issueDumpFilePath + ", targetSOPatterns=" + Arrays.toString(this.targetSOPatterns) + ", ignoredSOPatterns=" + Arrays.toString(this.ignoredSOPatterns) + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.matrix.memguard.MemGuard.Options
 * JD-Core Version:    0.7.0.1
 */