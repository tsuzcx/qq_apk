package com.danikula.videocache;

import com.danikula.videocache.file.DiskUsage;
import com.danikula.videocache.file.FileNameGenerator;
import com.danikula.videocache.headers.HeaderInjector;
import com.danikula.videocache.sourcestorage.SourceInfoStorage;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

class Config
{
  public final File cacheRoot;
  public final DiskUsage diskUsage;
  public final FileNameGenerator fileNameGenerator;
  public final HeaderInjector headerInjector;
  public final SourceInfoStorage sourceInfoStorage;
  
  Config(File paramFile, FileNameGenerator paramFileNameGenerator, DiskUsage paramDiskUsage, SourceInfoStorage paramSourceInfoStorage, HeaderInjector paramHeaderInjector)
  {
    this.cacheRoot = paramFile;
    this.fileNameGenerator = paramFileNameGenerator;
    this.diskUsage = paramDiskUsage;
    this.sourceInfoStorage = paramSourceInfoStorage;
    this.headerInjector = paramHeaderInjector;
  }
  
  File generateCacheFile(String paramString)
  {
    AppMethodBeat.i(190271);
    paramString = this.fileNameGenerator.generate(paramString);
    paramString = new File(this.cacheRoot, paramString);
    AppMethodBeat.o(190271);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.danikula.videocache.Config
 * JD-Core Version:    0.7.0.1
 */