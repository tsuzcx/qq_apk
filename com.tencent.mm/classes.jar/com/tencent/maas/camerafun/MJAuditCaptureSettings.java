package com.tencent.maas.camerafun;

import com.tencent.maas.instamovie.mediafoundation.b;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class MJAuditCaptureSettings
{
  private final b captureDimensionLevel;
  private final double captureFrameInterval;
  private final String outputDirPath;
  private final String outputFilenameBase;
  private final MJAuditCaptureSettings.MJAuditCaptureOutputType outputType;
  
  public MJAuditCaptureSettings(b paramb, double paramDouble, MJAuditCaptureSettings.MJAuditCaptureOutputType paramMJAuditCaptureOutputType, String paramString1, String paramString2)
  {
    this.captureDimensionLevel = paramb;
    this.captureFrameInterval = paramDouble;
    this.outputType = paramMJAuditCaptureOutputType;
    this.outputDirPath = paramString1;
    this.outputFilenameBase = paramString2;
  }
  
  public int getCaptureDimensionLevel()
  {
    return this.captureDimensionLevel.id;
  }
  
  public double getCaptureFrameInterval()
  {
    return this.captureFrameInterval;
  }
  
  public String getOutputDirPath()
  {
    return this.outputDirPath;
  }
  
  public String getOutputFilenameBase()
  {
    return this.outputFilenameBase;
  }
  
  public int getOutputType()
  {
    AppMethodBeat.i(216867);
    int i = this.outputType.getValue();
    AppMethodBeat.o(216867);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.maas.camerafun.MJAuditCaptureSettings
 * JD-Core Version:    0.7.0.1
 */