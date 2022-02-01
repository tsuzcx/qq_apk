package com.tencent.mm.modelsfs;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;

public class SFSContext$Statistics
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  public BlockFile[] blockFiles;
  public long blockSizeEmpty;
  public long blockSizeUsed;
  public BlockType[] blockTypes;
  public long overflowActualSize;
  public long totalActualSize;
  
  public String toString()
  {
    int k = 0;
    AppMethodBeat.i(156020);
    Object localObject1 = new StringBuilder(4096);
    ((StringBuilder)localObject1).append("Total:\n\tActualSize: ").append(this.totalActualSize).append('\n').append("\tUsedBlockSize: ").append(this.blockSizeUsed).append('\n').append("\tEmptyBlockSize: ").append(this.blockSizeEmpty).append('\n').append("\tOverflowSize: ").append(this.overflowActualSize).append('\n');
    int i = 0;
    int j;
    Object localObject2;
    for (;;)
    {
      j = k;
      if (i >= this.blockTypes.length) {
        break;
      }
      localObject2 = this.blockTypes[i];
      ((StringBuilder)localObject1).append("BlockType: ").append(((BlockType)localObject2).blockSize).append('\n').append("\tUsedCount: ").append(((BlockType)localObject2).usedCount).append('\n').append("\tEmptyCount: ").append(((BlockType)localObject2).emptyCount).append('\n').append("\tActualSize: ").append(((BlockType)localObject2).actualSize).append('\n');
      i += 1;
    }
    while (j < this.blockFiles.length)
    {
      localObject2 = this.blockFiles[j];
      ((StringBuilder)localObject1).append("BlockFile: ").append(j).append('\n').append("\tFileSize: ").append(((BlockFile)localObject2).fileSize).append('\n').append("\tUsedBlockCount: ").append(((BlockFile)localObject2).blockCount).append('\n').append("\tEmptyBlockCount: ").append(((BlockFile)localObject2).emptyCount).append('\n').append("\tTimestamp: ").append(((BlockFile)localObject2).timestamp).append('\n').append("\tDeleted: ").append(((BlockFile)localObject2).deleted).append('\n');
      j += 1;
    }
    localObject1 = ((StringBuilder)localObject1).toString();
    AppMethodBeat.o(156020);
    return localObject1;
  }
  
  public static class BlockFile
    implements Serializable
  {
    private static final long serialVersionUID = 1L;
    public int blockCount;
    public boolean deleted;
    public int emptyCount;
    public long fileSize;
    public long timestamp;
  }
  
  public static class BlockType
    implements Serializable
  {
    private static final long serialVersionUID = 1L;
    public long actualSize;
    public int blockSize;
    public int emptyCount;
    public int usedCount;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.modelsfs.SFSContext.Statistics
 * JD-Core Version:    0.7.0.1
 */