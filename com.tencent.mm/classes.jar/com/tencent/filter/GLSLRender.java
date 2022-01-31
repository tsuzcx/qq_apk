package com.tencent.filter;

import android.graphics.Bitmap;

public class GLSLRender
{
  public static int GL_TEXTURE_2D;
  public static int bcE = 0;
  public static int bcF = 1;
  public static int bcG = 2;
  public static int bcH = 3;
  public static int bcI = 4;
  public static int bcJ = 5;
  public static int bcK = 6;
  public static int bcL = 7;
  public static int bcM = 8;
  public static int bcN = 9;
  public static int bcO = 10;
  public static int bcP = 11;
  public static int bcQ = 12;
  public static int bcR = 13;
  public static int bcS = 14;
  public static int bcT = 15;
  public static int bcU = 16;
  public static int bcV = 17;
  public static int bcW = 18;
  public static int bcX = 19;
  public static int bcY = 20;
  public static int bcZ = 21;
  public static int bdA;
  public static int bdB;
  public static int bdC;
  public static int bdD;
  public static int bdE;
  public static int bdF;
  public static int bdG;
  public static int bdH;
  public static int bdI;
  public static int bdJ;
  public static int bdK;
  public static int bdL;
  public static int bdM;
  public static int bdN;
  public static int bdO;
  public static int bdP;
  public static int bdQ;
  public static int bdR;
  public static int bdS;
  public static int bdT;
  public static int bdU;
  public static int bdV;
  public static int bdW;
  public static int bdX;
  public static int bdY;
  public static int bdZ;
  public static int bda = 22;
  public static int bdb = 23;
  public static int bdc = 24;
  public static int bdd = 25;
  public static int bde = 26;
  public static int bdf = 27;
  public static int bdg = 28;
  public static int bdh = 29;
  public static int bdi = 30;
  public static int bdj = 31;
  public static int bdk = 32;
  public static int bdl = 33;
  public static int bdm = 34;
  public static int bdn = 35;
  public static int bdo = 36;
  public static int bdp = 37;
  public static int bdq = 38;
  public static int bdr = 39;
  public static int bds = 40;
  public static int bdt = 41;
  public static int bdu = 42;
  public static int bdv = 43;
  public static int bdw = 44;
  public static int bdx = 45;
  public static int bdy = 46;
  public static int bdz = 47;
  public static int beA;
  public static int beB;
  public static int beC;
  public static int beD;
  public static int beE;
  public static int beF;
  public static int beG;
  public static int beH;
  public static int beI;
  public static int beJ;
  public static int beK;
  public static int beL;
  public static int beM;
  public static int beN;
  public static int beO;
  public static int beP;
  public static int beQ;
  public static int beR;
  public static int beS;
  public static int beT;
  public static int beU;
  public static int beV;
  public static int beW;
  public static int beX;
  public static int beY;
  public static int beZ;
  public static int bea;
  public static int beb;
  public static int bec;
  public static int bed;
  public static int bee;
  public static int bef;
  public static int beg;
  public static int beh;
  public static int bei;
  public static int bej;
  public static int bek;
  public static int bel;
  public static int bem;
  public static int ben;
  public static int beo;
  public static int bep;
  public static int beq;
  public static int ber;
  public static int bes;
  public static int bet;
  public static int beu;
  public static int bev;
  public static int bew;
  public static int bex;
  public static int bey;
  public static int bez;
  public static int bfA = 12;
  public static int bfB = 13;
  public static int bfa;
  public static int bfb;
  public static int bfc;
  public static int bfd;
  public static int bfe;
  public static int bff;
  public static int bfg;
  public static int bfh;
  public static int bfi;
  public static int bfj;
  public static int bfk;
  public static int bfl;
  public static int bfm;
  public static int bfn;
  public static int bfo;
  public static int bfp;
  public static int bfq;
  public static int bfr;
  public static int bfs;
  public static int bft;
  public static int bfu;
  public static int bfv;
  public static int bfw;
  public static int bfx;
  public static int bfy;
  public static int bfz;
  
  static
  {
    bdA = 48;
    bdB = 49;
    bdC = 50;
    bdD = 51;
    bdE = 52;
    bdF = 53;
    bdG = 54;
    bdH = 55;
    bdI = 56;
    bdJ = 57;
    bdK = 58;
    bdL = 59;
    bdM = 60;
    bdN = 61;
    bdO = 62;
    bdP = 63;
    bdQ = 64;
    bdR = 65;
    bdS = 66;
    bdT = 67;
    bdU = 68;
    bdV = 69;
    bdW = 70;
    bdX = 71;
    bdY = 72;
    bdZ = 73;
    bea = 74;
    beb = 75;
    bec = 76;
    bed = 77;
    bee = 78;
    bef = 79;
    beg = 80;
    beh = 81;
    bei = 82;
    bej = 83;
    bek = 84;
    bel = 85;
    bem = 86;
    ben = 87;
    beo = 88;
    bep = 89;
    beq = 90;
    ber = 91;
    bes = 92;
    bet = 93;
    beu = 94;
    bev = 95;
    bew = 96;
    bex = 97;
    bey = 98;
    bez = 99;
    beA = 100;
    beB = 101;
    beC = 102;
    beD = 103;
    beE = 104;
    beF = 105;
    beG = 106;
    beH = 107;
    beI = 108;
    beJ = 109;
    beK = 110;
    beL = 111;
    beM = 112;
    beN = 113;
    beO = 114;
    beP = 115;
    beQ = 116;
    beR = 117;
    beS = 118;
    beT = 119;
    beU = 120;
    beV = 121;
    beW = 122;
    beX = 123;
    beY = 124;
    beZ = 125;
    bfa = 126;
    bfb = 127;
    bfc = 128;
    bfd = 129;
    bfe = 130;
    bff = 131;
    bfg = 132;
    bfh = 133;
    bfi = 134;
    bfj = 135;
    bfk = 136;
    bfl = 137;
    bfm = 138;
    bfn = 36197;
    GL_TEXTURE_2D = 3553;
    bfo = 0;
    bfp = 1;
    bfq = 2;
    bfr = 3;
    bfs = 4;
    bft = 5;
    bfu = 6;
    bfv = 7;
    bfw = 8;
    bfx = 9;
    bfy = 10;
    bfz = 11;
  }
  
  public static native long nativeAllocBuffer(int paramInt);
  
  public static native void nativeBeginUseEglImage(int paramInt1, int paramInt2, int paramInt3);
  
  public static native void nativeCalHistogramFromGPU(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat1, float paramFloat2, int paramInt5, int paramInt6, float paramFloat3, float paramFloat4);
  
  public static native int nativeCheckMagicEngine(int paramInt1, int paramInt2);
  
  public static native int nativeCopyPixelToBitmap(Bitmap paramBitmap);
  
  public static native int nativeCopyPixelToBitmapWithShare(Bitmap paramBitmap, int paramInt1, int paramInt2);
  
  public static native void nativeCopyTexturToDataWithShare(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, int paramInt4);
  
  public static native QImage nativeCopyTexture(int paramInt1, int paramInt2);
  
  public static native void nativeCopyTexture2(QImage paramQImage);
  
  public static native QImage nativeCopyTextureWithShare(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public static native int nativeDeinitMagicEngine(int paramInt);
  
  public static native void nativeEndUseEglImage(int paramInt1, int paramInt2, int paramInt3);
  
  public static native void nativeFreeBuffer(long paramLong);
  
  public static native int nativeInitMagicEngine(int paramInt1, int paramInt2);
  
  public static native void nativePickJepgToTexture(QImage paramQImage, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int[] paramArrayOfInt);
  
  public static native void nativePreprocessJepg(QImage paramQImage, int[] paramArrayOfInt);
  
  public static native void nativePreviewData(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3);
  
  public static native void nativePreviewYuvData(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3);
  
  public static native void nativePushBitmapFromTexture(Bitmap paramBitmap, int paramInt);
  
  public static native void nativePushDataFromTexture(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3);
  
  public static native void nativePushJepgFromTexture(QImage paramQImage, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
  
  public static native int nativeRenderPixelToBitmap(Bitmap paramBitmap, int paramInt1, int paramInt2);
  
  public static native int nativeSnap(Bitmap paramBitmap);
  
  public static native void nativeTextCure(int[] paramArrayOfInt, int paramInt);
  
  public static native void nativeTextImage(QImage paramQImage, int paramInt);
  
  public static native void nativeToRGBData(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public static native void nativeUpdateScaleBitmap(Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3, int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.filter.GLSLRender
 * JD-Core Version:    0.7.0.1
 */